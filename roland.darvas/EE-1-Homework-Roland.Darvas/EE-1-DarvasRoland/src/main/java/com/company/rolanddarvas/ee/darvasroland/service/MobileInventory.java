package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.exception.MobileAlreadyRegistrated;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author darvasr
 */
public class MobileInventory {

    private Map<MobileType, Integer> mobileIventory = new HashMap<>();

    public MobileType addNewMobileType(MobileType mobile) {
        if (!mobileIventory.containsKey(mobile)) {
            mobile.setId(UUID.randomUUID().toString());
            mobileIventory.put(mobile, 0);
            return mobile;
        } else {
            throw new MobileAlreadyRegistrated("mobile already in the database!");
        }
    }

    public boolean reserveMobile(MobileType mobile, int amount) {
        if (mobileIventory.containsKey(mobile) && mobileIventory.get(mobile) >= amount) {
            mobileIventory.put(mobile, mobileIventory.get(mobile) - amount);
            return true;
        } else {
            return false;
        }

    }

    public boolean returnMobile(MobileType mobile, int amount) {
        if (mobileIventory.containsKey(mobile)) {
            mobileIventory.put(mobile, mobileIventory.get(mobile) + amount);
            return true;
        } else {
            return false;
        }

    }

}
