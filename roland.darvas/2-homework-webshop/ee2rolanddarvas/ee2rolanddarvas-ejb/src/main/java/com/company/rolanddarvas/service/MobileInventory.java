package com.company.rolanddarvas.service;

import com.company.rolanddarvas.annotation.ValidatorInterceptor;
import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.exception.MobileAlreadyRegistered;
import com.company.rolanddarvas.exception.NoSuchMobileException;

import javax.ejb.Singleton;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by darvasr on 2016.07.28..
 */
@Singleton
public class MobileInventory implements Serializable{

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
        for (Map.Entry<MobileType, Integer> mobileEntry : inventory.entrySet()) {
            MobileType mobile = mobileEntry.getKey();
            if (mobile.getId().equals(id)) {
                return mobile;
            }
        }
        throw new NoSuchMobileException("No mobile in the inventory with such id!");
    }


    public Integer count(String id) {
        return inventory.entrySet().stream().filter(i -> i.getKey().getId().equals(id))
                .map(Map.Entry::getValue).findFirst().get();
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

    public String getInventoryAsString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<MobileType, Integer> mobileEntry : inventory.entrySet()) {
            MobileType mobile = mobileEntry.getKey();
            sb.append("mobile memory address: ").append(mobile).append("\n")
                    .append("It's id: ").append(mobile.getId()).append("\n")
                    .append("It's manufacturer:").append(mobile.getManufacturer()).append("\n")
                    .append("It's type:").append(mobile.getType()).append("\n")
                    .append("It's price:").append(mobile.getPrice()).append("\n")
                    .append("the currency:").append(mobile.getCurrency().toString()).append("\n")
                    .append("It's color:").append(mobile.getColor().toString()).append("\n");
        }
        return sb.toString();
    }
}
