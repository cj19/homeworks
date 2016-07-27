package com.company.rolanddarvas.ee.darvasroland.service;

import com.company.rolanddarvas.ee.darvasroland.dto.MobileType;
import com.company.rolanddarvas.ee.darvasroland.model.CurrencyType;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.07.27..
 */

public class Cart {

    private Map<MobileType, Integer> shoppingCart = new HashMap<>();

    private MobileInventory mobileInventory;

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

    public Cart(MobileInventory mobileInventory) {
        this.mobileInventory = mobileInventory;
    }

    public void add(MobileType id, int amountToAdd) {
        if (amountToAdd <= 0) {
            throw new IllegalArgumentException("Amount can't be 0 or less!");
        }
        if (!mobileInventory.reserveMobile(id, amountToAdd)) {
            throw new IllegalArgumentException("We are not able to reserve that amountToAdd of mobile!");
        }
        int amountInCart = shoppingCart.getOrDefault(id, 0);
        shoppingCart.put(id, amountInCart + amountToAdd);
    }

    public void delete(MobileType id, int amountToDelete) {
        if (amountToDelete <= 0) {
            throw new IllegalArgumentException("Can't delete 0 or less mobiles...!");
        }
        int itemsInCart = shoppingCart.getOrDefault(id, 0);
        if (amountToDelete > itemsInCart) {
            throw new IllegalArgumentException("There is less amount in your cart!");
        }
        shoppingCart.put(id, itemsInCart - amountToDelete);
        mobileInventory.returnMobile(id, amountToDelete);
    }

    public void clear() {
        for (Map.Entry<MobileType, Integer> entry : shoppingCart.entrySet()) {
            MobileType mobile = entry.getKey();
            Integer amount = entry.getValue();
            mobileInventory.returnMobile(mobile, amount);
        }
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (Map.Entry<MobileType, Integer> entry : shoppingCart.entrySet()) {
            MobileType mobile = entry.getKey();
            Integer amount = entry.getValue();
            totalPrice = calculatePriceToHUF(mobile, amount);
        }
        return totalPrice;
    }


    public void checkout(){
        StringBuilder checkList = new StringBuilder();
        Double totalPrice = 0.0;
        for (Map.Entry<MobileType, Integer> entry : shoppingCart.entrySet()) {
            MobileType mobile = entry.getKey();
            Integer amount = entry.getValue();

            checkList.append("\nItem: " + "\n")
                    .append("Name: "+mobile.getType()).append(" ")
                    .append(amount).append(" pieces \nItem price: ")
                    .append(mobile.getPrice()+"/piece")
                    .append("\n(Sub)total price: ")
                    .append(""+calculatePriceToHUF(mobile, amount)+" HUF");
            totalPrice += calculatePriceToHUF(mobile, amount);
        }
        checkList.append("\nTotal price: ").append(totalPrice.toString()+" HUF");
        LOGGER.log(Level.INFO, checkList.toString());
    }

    //calculate price in current rate currency
    private Double calculatePriceToHUF(MobileType mobile, Integer amount) {
        if (mobile.getCurrency() == CurrencyType.EUR) {
            return multiplyParameters(mobile.getPrice(), 313.19, amount);
        }
        if (mobile.getCurrency() == CurrencyType.USD){
            return multiplyParameters(mobile.getPrice(), 284.74, amount);
        } else {
            return amount*mobile.getPrice();
        }
    }

    private Double multiplyParameters(Double price, Double rate, Integer amount) {
        return amount*(rate*price);
    }
}
