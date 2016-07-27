package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.dto.UserDTO;
import com.company.rolanddarvas.ee.darvasroland.exception.NoSuchUserException;
import com.company.rolanddarvas.ee.darvasroland.exception.UserAlreadyRegistrated;
import com.company.rolanddarvas.ee.darvasroland.model.Gender;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author darvasr
 */
public class UserDBTest {

    private UserDB testUserDB;
    private UserDTO testUser;

    @Before
    public void initTest() {
        testUserDB = new UserDB();
        testUser = createTestUser();
        testUserDB.registrate(testUser);
    }

    @Test
    public void createNewUser() {
        UserDTO createdUser = testUserDB.getUser(testUser.getUsername());
        Assert.assertEquals(testUserDB.getUser(testUser.getUsername()), createdUser);
    }

    @Test(expected = UserAlreadyRegistrated.class)
    public void registerTwice(){
        UserDTO createdUser = testUserDB.getUser(testUser.getUsername());
        UserDTO returnedUser = testUserDB.registrate(createdUser);
        Assert.assertEquals(null, returnedUser);
    }
    
    @Test
    public void getRegistratedUser(){
        UserDTO returnedUser = testUserDB.getUser(testUser.getUsername());
        Assert.assertEquals(testUser.getUsername(), returnedUser.getUsername());
    }
    
    @Test(expected = NoSuchUserException.class)
    public void getNonExistingUser(){
        UserDTO returnedUser = testUserDB.getUser("béla");
        Assert.assertEquals(null, returnedUser);
    }
    
    @Test
    public void authenticationSuccessful(){
        boolean isAuthenticated = authenticate(testUser.getUsername(), testUser.getPassword());
        Assert.assertTrue(isAuthenticated);
    }
    
    @Test
    public void authenticationFailure(){
        boolean isAuthenticated = authenticate(testUser.getUsername(), "asdasd");
        Assert.assertFalse(isAuthenticated);
    }

    private boolean authenticate(String username, String password) {
        return testUserDB.authenticate(username, password);
    }
    private UserDTO createTestUser() {
        return new UserDTO.Builder().username("darvasr").password("12aZ=>")
                .firstName("Roland").lastName("Darvas").address("1234asd")
                .phone("+36303844809").email("darvas.roland@gmail.com").sex(Gender.MALE)
                .registrationDate(new Date(System.currentTimeMillis() - 10000))
                .dateOfBirth(new Date(System.currentTimeMillis() - 20000)).admin(true)
                .build();

    }

}
