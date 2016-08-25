package com.company.rolanddarvas.util.management;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.exception.custom.shared.NotEnoughMoney;
import com.company.rolanddarvas.exception.custom.visitor.AgeLimit;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorManagement {

    private VisitorManagement() {
        //no instantiate
    }

    public static void payEntryTicket(AmusementPark amusementPark, Visitor visitor) {
        Long ticketPrice = amusementPark.getTicketPrice();
        Long remainingMoney = visitor.getMoney() - ticketPrice;
        if (remainingMoney < 0.0) {
            throw new NotEnoughMoney("Visitor doesn't have enough money to enter the park!");
        }
        visitor.setMoney(remainingMoney);
        amusementPark.setFund(amusementPark.getFund() + ticketPrice);
    }

    public static void payMachineTicket(Machine machine, Visitor visitor) {
        Long ticketPrice = machine.getTicketPrice();
        Long remainingMoney = visitor.getMoney() - ticketPrice;
        if (remainingMoney < 0.0) {
            throw new NotEnoughMoney("Visitor doesn't have enough money for the machine ticket!");
        }
        AmusementPark amusementPark = machine.getAmusementPark();
        amusementPark.setFund(amusementPark.getFund() + ticketPrice);
        visitor.setMoney(remainingMoney);
    }

    private static boolean isAboveAgeLimit(Machine machine, Visitor visitor) {
        return visitor.getAge() >= machine.getAgeLimit();
    }

    public static void checkAgeLimit(Machine machine, Visitor visitor) {
        if (!isAboveAgeLimit(machine, visitor)) {
            throw new AgeLimit("Visitor is not old enough!");
        }
    }
}
