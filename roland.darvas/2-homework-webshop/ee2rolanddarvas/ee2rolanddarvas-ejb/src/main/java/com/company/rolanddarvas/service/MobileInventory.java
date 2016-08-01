package com.company.rolanddarvas.service;

import com.company.rolanddarvas.annotation.ValidatorInterceptor;
import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.exception.MobileAlreadyRegistered;
import com.company.rolanddarvas.exception.NoSuchMobileException;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by darvasr on 2016.07.28..
 */
@Singleton
public class MobileInventory {

    private Map<MobileType, Integer> inventory = new HashMap<>();

    @ValidatorInterceptor
    public MobileType addNewMobileType(MobileType mobile) {
        if (!inventory.containsKey(mobile)) {
            mobile.setId(UUID.randomUUID().toString());
            inventory.put(mobile, 0);
            return mobile;
        } else {
            throw new MobileAlreadyRegistered("mobile already in the database!");
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

    public boolean removeMobile(MobileType mobileType) {
        if (inventory.containsKey(mobileType)) {
            inventory.remove(mobileType);
            return true;
        } else {
            throw new NoSuchMobileException("there is no such mobile in the inventory!");
        }
    }

    public MobileType getMobileById(String id) {
        return inventory.entrySet().stream().filter(i -> i.getKey().getId().equals(id)).findFirst().get().getKey();
    }

    public Map<MobileType, Integer> getInventory() {
        return inventory;
    }

    public Optional<Integer> count(String id) {
        return inventory.entrySet().stream().filter(i -> i.getKey().getId().equals(id))
                .map(Map.Entry::getValue).findFirst();
    }

    public void increment(String id, Integer amount) {
        inventory.entrySet().stream().filter(mobile -> mobile.getKey().getId().equals(id)).forEach(mobile -> {
            Integer value = mobile.getValue() + amount;
            mobile.setValue(value);
        });
    }

    public void decrement(String id, Integer amount) {
        inventory.entrySet().stream().filter(mobile -> mobile.getKey().getId().equals(id)).forEach(mobile -> {
            Integer value = mobile.getValue() - amount;
            mobile.setValue(value);
        });
    }
}
