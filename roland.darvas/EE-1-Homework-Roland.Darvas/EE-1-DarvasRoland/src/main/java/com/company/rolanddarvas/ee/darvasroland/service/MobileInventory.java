package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.annotation.ValidatorInterceptor;
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

    private Map<MobileType, Integer> inventory = new HashMap<>();

    @ValidatorInterceptor
    public MobileType addNewMobileType(MobileType mobile) {
        if (!inventory.containsKey(mobile)) {
            mobile.setId(UUID.randomUUID().toString());
            inventory.put(mobile, 0);
            return mobile;
        } else {
            throw new MobileAlreadyRegistrated("mobile already in the database!");
        }
    }

    @ValidatorInterceptor
    public boolean reserveMobile(MobileType mobile, int amount) {
        if (inventory.containsKey(mobile) && inventory.get(mobile) >= amount) {
            inventory.put(mobile, inventory.get(mobile) - amount);
            return true;
        } else {
            return false;
        }

    }

    @ValidatorInterceptor
    public boolean returnMobile(MobileType mobile, int amount) {
        if (inventory.containsKey(mobile)) {
            inventory.put(mobile, inventory.get(mobile) + amount);
            return true;
        } else {
            return false;
        }

    }

}
