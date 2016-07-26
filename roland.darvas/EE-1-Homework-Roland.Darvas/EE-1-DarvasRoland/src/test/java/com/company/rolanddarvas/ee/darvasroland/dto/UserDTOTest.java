package com.company.rolanddarvas.ee.darvasroland.dto;

import com.company.rolanddarvas.ee.darvasroland.model.Gender;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author darvasr
 */
public class UserDTOTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private static UserDTO testUserDTO;

    @Before
    public void setTestObject() {
        testUserDTO = createTestUser();
    }

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void allFieldsAreCorrect() {
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void userNameNotLongEnough() {
        String usernameShort = "sad";
        testUserDTO.setUsername(usernameShort);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(usernameShort,
                violations.iterator().next().getInvalidValue());
    }

    @Test
    public void userNameIsNull() {
        testUserDTO.setUsername(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void passwordWithoutSpecialChar() {
        String passwordWrong = "darvasr";
        testUserDTO.setPassword(passwordWrong);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(passwordWrong,
                violations.iterator().next().getInvalidValue());

    }

    @Test
    public void passwordWithSpecialChar() {
        String passwordShort = "darvasr~";
        testUserDTO.setPassword(passwordShort);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(passwordShort,
                violations.iterator().next().getInvalidValue());
    }

    @Test
    public void passwordIsNotLongEnough() {
        testUserDTO.setPassword("123aS");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Password.message}",
                violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void passwordIsNull() {
        testUserDTO.setPassword(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void addressIsStartsWithLetter() {
        testUserDTO.setAddress("asdasad123");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Address.message}",
                violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void addressIsNull() {
        testUserDTO.setAddress(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void phoneSecondOptionIsCorrect() {
        testUserDTO.setPhone("06303844809");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void phoneIsNull() {
        testUserDTO.setPhone(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void phoneWrongNumber() {
        String phoneShort = "+273522328";
        testUserDTO.setAddress(phoneShort);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(phoneShort, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void phoneHasTooManyNumber() {
        testUserDTO.setPhone("+363038448095");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Phone.message}",
                violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void emailIsWrong() {
        String emailWrong = "@asda.com";
        testUserDTO.setEmail(emailWrong);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(emailWrong, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void registrationDateIsNotInPast() {
        testUserDTO.setRegistrationDate(new Date(System.currentTimeMillis() + 100));
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void firstLastNameNull() {
        testUserDTO.setFirstName(null);
        testUserDTO.setLastName(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void firstNameNullOnly() {
        testUserDTO.setFirstName(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{NameCheck.message}",
                violations.iterator().next().getMessageTemplate());

    }

    @Test
    public void dateOfBirthAfterRegDate() {
        testUserDTO.setDateOfBirth(new Date(System.currentTimeMillis()));
        testUserDTO.setRegistrationDate(new Date());
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void dateOfBirthIsNull() {
        testUserDTO.setDateOfBirth(null);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void registrationDateIsInFuture() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        testUserDTO.setRegistrationDate(futureDate);
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(testUserDTO);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(futureDate, violations.iterator().next().getInvalidValue());
    }

    private UserDTO createTestUser() {
        return new UserDTO.Builder().username("darvasr").password("12aZ=>")
                .firstName("Roland").lastName("Darvas").address("1234asd")
                .phone("+36303844809").email("darvas.roland@gmail.com").sex(Gender.MALE)
                .registrationDate(new Date(System.currentTimeMillis() - 100000))
                .dateOfBirth(new Date(System.currentTimeMillis() - 200000)).admin(true)
                .build();
    }
}
