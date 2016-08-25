package com.company.rolanddarvas.util.management;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.exception.custom.park.*;
import com.company.rolanddarvas.exception.custom.shared.NotEnoughMoney;

import java.util.Objects;

/**
 * Created by darvasr on 2016.08.21..
 */
public class AmusementParkManagement {

    private AmusementParkManagement() {
        //no instantiate
    }

    private static boolean isVisitorInAmusementPark(Visitor visitor) {
        return visitor.hasAmusementPark();
    }

    public static void checkVisitorInAmusementPark(Visitor visitor) {
        if (!isVisitorInAmusementPark(visitor)) {
            throw new VisitorIsInAmusementPark("Visitor is not in a park!");
        }
    }

    public static void checkVisitorNotInAmusementPark(Visitor visitor) {
        if (isVisitorInAmusementPark(visitor)) {
            throw new VisitorIsInAmusementPark("Visitor is in a park!");
        }
    }

    private static boolean areMachineAndVisitorInTheSamePark(Visitor visitor, Machine machine) {
        AmusementPark amusementPark = visitor.getCurrentPark();
        return amusementPark != null && Objects.equals(amusementPark, machine.getAmusementPark());
    }

    public static void checkMachineAndVisitorAreInTheSamePark(Visitor visitor, Machine machine) {
        if (!areMachineAndVisitorInTheSamePark(visitor, machine)) {
            throw new NotInTheSamePark("Machine and the visitor are not in the same park!");
        }
    }

    private static boolean isEmptyPark(AmusementPark amusementPark) {
        return amusementPark.getMachines().isEmpty() && amusementPark.getVisitors().isEmpty();
    }

    public static void checkEmptyPark(AmusementPark amusementPark) {
        if (!isEmptyPark(amusementPark)) {
            throw new AmusementParkIsNotEmpty("Amusement Park is not empty yet!");
        }
    }

    private static boolean hasEnoughFreeLand(AmusementPark amusementPark, Machine machine) {
        Long land = amusementPark.getLand();
        for (Machine machineInPark : amusementPark.getMachines()) {
            land -= machineInPark.getSize();
        }
        return (Long.compare(land, machine.getSize())) > 0;
    }

    public static void checkParkHasFreeLand(AmusementPark amusementPark, Machine machine) {
        if (!hasEnoughFreeLand(amusementPark, machine)) {
            throw new NotFreeLandLeftInPark("Not free space for the machine in this Amusement Park!");
        }
    }

    public static void buyMachine(AmusementPark amusementPark, Machine machine) {
        Long machinePrice = machine.getPrice();
        Long remainingMoney = amusementPark.getFund() - machinePrice;
        if (remainingMoney < 0.0) {
            throw new NotEnoughMoney("Not enough funds to buy this machine");
        }
        amusementPark.setFund(remainingMoney);
    }

    public static void removeMachineFromAmusementPark(Machine machine) {
        if (!isMachineInThisAmusementPark(machine)) {
            throw new MachineIsNotInThisPark("Machine is not in this Amusement Park, can't be removed!");
        }
        machine.getAmusementPark().getMachines().remove(machine);
        machine.setAmusementPark(null);
    }

    public static void transferFunds(Machine machine) {
        if (isMachineInThisAmusementPark(machine)) {
            AmusementPark amusementPark = machine.getAmusementPark();
            amusementPark.setLand(amusementPark.getLand() + machine.getSize());
            amusementPark.setFund(amusementPark.getFund() + machine.getPrice());
        }
    }


    private static boolean isMachineInThisAmusementPark(Machine machine) {
        return machine.getAmusementPark() != null;
    }
}
