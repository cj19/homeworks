package com.company.rolanddarvas.ee.darvasroland.program;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import com.company.rolanddarvas.ee.darvasroland.service.MobileInventory;
import com.company.rolanddarvas.ee.darvasroland.service.UserDB;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author darvasr
 */
public class Main {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final UserDB USER = new UserDB();

    private static final MobileInventory INVENTORY = new MobileInventory();
    
    private static final String USERS_FILE = "users.json";
    
    private static final String MOBILES_FILE = "mobiles.json";

    private Main() {
    }

    private static void importUsers() throws IOException {
        List<UserDTO> users = MAPPER.readValue(Main.class.getClassLoader()
                .getResource(USERS_FILE),
                new TypeReference<List<UserDTO>>() {
        });
        users.stream().forEach(USER::registrate);
    }

    private static void importMobiles() throws IOException {

        List<MobileType> mobileTypes = MAPPER
                .readValue(Main.class.getClassLoader().getResource(MOBILES_FILE),
                        new TypeReference<List<MobileType>>() {
                });

        mobileTypes.stream().forEach(INVENTORY::addNewMobileType);

    }

    public static void main(String[] args) throws IOException {
        importUsers();
        importMobiles();
    }

}
