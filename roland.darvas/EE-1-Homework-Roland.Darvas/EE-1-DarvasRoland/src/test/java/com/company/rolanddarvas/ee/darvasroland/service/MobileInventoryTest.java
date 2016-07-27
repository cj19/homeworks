package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.exception.MobileAlreadyRegistrated;
import com.company.rolanddarvas.ee.darvasroland.model.Brand;
import com.company.rolanddarvas.ee.darvasroland.model.ColorType;
import com.company.rolanddarvas.ee.darvasroland.model.CurrencyType;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author darvasr
 */
public class MobileInventoryTest {

    private MobileInventory testMobileInventory;

    private MobileType testMobile;
    
    private MobileType testMobile2;

    @Before
    public void initTest() {
        testMobileInventory = new MobileInventory();
        testMobile = createTestMobile();
        testMobile2 = testMobileInventory.addNewMobileType(testMobile);
    }

    @Test
    public void addNewMobile(){
        Assert.assertEquals(testMobile2, testMobile);
    }
    
    @Test(expected = MobileAlreadyRegistrated.class)
    public void mobileAlreadyExists(){
        MobileType returnedMobile = testMobileInventory.addNewMobileType(testMobile2);
        Assert.assertEquals(null, returnedMobile);
    }
    
    @Test
    public void reserveMobileSucceed(){
        testMobileInventory.returnMobile(testMobile, 5);
        boolean isReserved = testMobileInventory.reserveMobile(testMobile, 5);
        Assert.assertTrue(isReserved);
    }
    
    @Test
    public void reserveMobileFailed(){
        boolean isReserved = testMobileInventory.reserveMobile(testMobile, 5);
        Assert.assertFalse(isReserved);
    }
    
    @Test
    public void returnMobileSucceed(){
        boolean isReturned = testMobileInventory.returnMobile(testMobile, 5);
        Assert.assertTrue(isReturned);
    }
    private MobileType createTestMobile() {
       return new MobileType(UUID.randomUUID().toString(),
                Brand.SAMSUNG, "Galaxy S7", 500, CurrencyType.EUR, ColorType.BLACK);
    }

}
