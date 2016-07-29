package com.company.rolanddarvas.service;

import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.07.28..
 */
@Singleton
@Startup
public class InitiateDB {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String USERS_FILE = "users.json";

    private static final String MOBILES_FILE = "mobiles.json";

    private static final Logger LOGGER = Logger.getLogger(InitiateDB.class.getName());


    private UserDB userDB;

    private MobileInventory mobileInventory;


    @PostConstruct
    public void init() {
        LOGGER.log(Level.INFO, "Init started!");
        try {
            importUsers();
            importMobiles();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Files not found!", e);
        }
        LOGGER.log(Level.INFO, "item: "+userDB.getUser("darvasr"));

    }

    private void importUsers() throws IOException {
        List<UserDTO> users = MAPPER.readValue(InitiateDB.class.getClassLoader()
                        .getResource(USERS_FILE),
                new TypeReference<List<UserDTO>>() {
                });
        users.stream().forEach(userDB::register);
    }

    private void importMobiles() throws IOException {
        List<MobileType> mobileTypes = MAPPER
                .readValue(InitiateDB.class.getClassLoader().getResource(MOBILES_FILE),
                        new TypeReference<List<MobileType>>() {
                        });

        mobileTypes.stream().forEach(mobileInventory::addNewMobileType);
    }

    @Inject
    public void setMobileInventory(MobileInventory mobileInventory) {
        this.mobileInventory = mobileInventory;
    }

    @Inject
    public void setUserDB(UserDB userDB) {
        this.userDB = userDB;
    }
}
