package com.company.rolanddarvas.service;

import com.company.rolanddarvas.dto.MobileType;
import com.company.rolanddarvas.model.CurrencyType;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by darvasr on 2016.07.28..
 */
@Stateful
@SessionScoped
public class Cart implements Serializable {

    private transient Map<MobileType, Integer> shoppingCart = new HashMap<>();

    @Inject
    private MobileInventory mobileInventory;

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

    public Cart(MobileInventory mobileInventory) {
        this.mobileInventory = mobileInventory;
    }

    public Cart() {
        //default constructor
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

    public void remove(MobileType id, int amountToDelete) {
        if (amountToDelete <= 0) {
            throw new IllegalArgumentException("Can't remove 0 or less mobiles...!");
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

    @Remove
    public String checkout(){
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
        return checkList.toString();
    }

    //calculate price in current rate currency
    private static Double calculatePriceToHUF(MobileType mobile, Integer amount) {
        if (mobile.getCurrency() == CurrencyType.EUR) {
            return multiplyParameters(mobile.getPrice(), 313.19, amount);
        }
        if (mobile.getCurrency() == CurrencyType.USD){
            return multiplyParameters(mobile.getPrice(), 284.74, amount);
        } else {
            return amount*mobile.getPrice();
        }
    }

    private static Double multiplyParameters(Double price, Double rate, Integer amount) {
        return amount*(rate*price);
    }
}