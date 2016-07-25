package com.company.rolanddarvas.ee.darvasroland.dto;

import com.company.rolanddarvas.ee.darvasroland.model.Brand;
import com.company.rolanddarvas.ee.darvasroland.model.ColorType;
import com.company.rolanddarvas.ee.darvasroland.model.CurrencyType;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author darvasr
 */
public class MobileTypeTest {

    private static ValidatorFactory vf;
    private static Validator validator;
    private static MobileType testMobileType;

    @Before
    public void setTestObject() {
        testMobileType = createTestMobile();
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
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void idWithRandomUUID() {
        testMobileType.setId(UUID.randomUUID().toString());
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(0, violations.size());

    }

    @Test
    public void idIsNull() {
        testMobileType.setId(null);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void idIsNotLongEnough() {
        testMobileType.setId("asdasdas");
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("asdasdas", violations.iterator().next().getInvalidValue());
    }

    @Test
    public void manufacturerIsNull() {
        testMobileType.setManufacturer(null);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void typeIsNotThreeLong() {
        testMobileType.setType("as");
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("as", violations.iterator().next().getInvalidValue());
    }

    @Test
    public void priceIsNull() {
        testMobileType.setPrice(null);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void currencyIsNull() {
        testMobileType.setCurrency(null);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void colorIsNull() {
        testMobileType.setColor(null);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void blackAppleMobile() {
        testMobileType.setColor(ColorType.BLACK);
        testMobileType.setManufacturer(Brand.APPLE);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void whiteApplePhone() {
        testMobileType.setColor(ColorType.WHITE);
        testMobileType.setManufacturer(Brand.APPLE);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void greenApplePhone() {
        testMobileType.setColor(ColorType.GREEN);
        testMobileType.setManufacturer(Brand.APPLE);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{ManufacturerWithColor.message}",
                violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void greenSamsungPhone() {
        testMobileType.setColor(ColorType.GREEN);
        testMobileType.setManufacturer(Brand.SAMSUNG);
        Set<ConstraintViolation<MobileType>> violations = validator.validate(testMobileType);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{ManufacturerWithColor.message}",
                violations.iterator().next().getMessageTemplate());
    }

    private MobileType createTestMobile() {
        return new MobileType("38400000-8cf0-11bd-b23e-10b96e4ef00d",
                Brand.HTC, "mobile", 500, CurrencyType.EUR, ColorType.BLUE);
    }
}
