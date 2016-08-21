package com.company.rolanddarvas.util.utility;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.entity.Visitor;

/**
 * Created by darvasr on 2016.08.21..
 */
public class Utility {

    private Utility() {
        //no instantiate
    }

    public static void addVisitorToPark(Visitor visitor, AmusementPark amusementPark) {
        visitor.setCurrentPark(amusementPark);
        amusementPark.getVisitors().add(visitor);
    }

    public static void addMachineToPark(Machine machine, AmusementPark amusementPark) {
        machine.setAmusementPark(amusementPark);
        amusementPark.getMachines().add(machine);
    }

    public static void addVisitorToMachine(Machine machine, Visitor visitor) {
        visitor.setCurrentMachine(machine);
        machine.getVisitors().add(visitor);
    }

    public static void removeVisitorFromPark(Visitor visitor, AmusementPark amusementPark) {
        amusementPark.getVisitors().remove(visitor);
        visitor.setCurrentPark(null);
    }

    public static void removeVisitorFromMachine(Machine machine, Visitor visitor) {
        machine.getVisitors().remove(visitor);
        visitor.setCurrentMachine(null);
    }
}



