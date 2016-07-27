package com.company.rolanddarvas.ee.darvasroland.program;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import com.company.rolanddarvas.ee.darvasroland.model.Brand;
import com.company.rolanddarvas.ee.darvasroland.model.ColorType;
import com.company.rolanddarvas.ee.darvasroland.model.CurrencyType;
import com.company.rolanddarvas.ee.darvasroland.service.Cart;
import com.company.rolanddarvas.ee.darvasroland.service.MobileInventory;
import com.company.rolanddarvas.ee.darvasroland.service.UserDB;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.validation.ValidationException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darvasr
 */
public class Main {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    private static final String USERS_FILE = "users.json";
    
    private static final String MOBILES_FILE = "mobiles.json";

    private static final Logger LOGGER =Logger.getLogger(Main.class.getName());

    private Main() {
    }

    private static void importUsers(UserDB userDB) throws IOException {
        List<UserDTO> users = MAPPER.readValue(Main.class.getClassLoader()
                .getResource(USERS_FILE),
                new TypeReference<List<UserDTO>>() {
        });
        users.stream().forEach(userDB::register);
    }

    private static List<MobileType> importMobiles(MobileInventory mobileInventory) throws IOException {

        List<MobileType> mobileTypes = MAPPER
                .readValue(Main.class.getClassLoader().getResource(MOBILES_FILE),
                        new TypeReference<List<MobileType>>() {
                });

        mobileTypes.stream().forEach(mobileInventory::addNewMobileType);
        return mobileTypes;
    }

    public static void main(String[] args) throws IOException {

        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();

        MobileInventory mobileInventory = weldContainer.instance().select(MobileInventory.class).get();
        UserDB userDB = weldContainer.instance().select(UserDB.class).get();

        //test interception type validation
        try {
            MobileType invalidType = new MobileType(null, Brand.APPLE, "bad", 500.0, CurrencyType.EUR, ColorType.BLACK);
            mobileInventory.reserveMobile(invalidType, 500);
        } catch (ValidationException ex) {
            LOGGER.log(Level.SEVERE, "Exception while adding mobile", ex);
        }

        //test cart
        importUsers(userDB);
        List<MobileType> importedTypes=importMobiles(mobileInventory);
        for (MobileType mobile : importedTypes) {
            mobileInventory.returnMobile(mobile, 50);
        }

        Cart testCart = new Cart(mobileInventory);
        testCart.add(importedTypes.get(0), 5);
        testCart.add(importedTypes.get(4), 5);
        testCart.delete(importedTypes.get(0), 1);
        testCart.checkout();

        weld.shutdown();
    }

}
