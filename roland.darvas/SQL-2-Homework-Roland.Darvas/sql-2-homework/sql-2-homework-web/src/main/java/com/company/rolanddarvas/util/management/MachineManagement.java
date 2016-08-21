package com.company.rolanddarvas.util.management;

import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.exception.custom.machine.*;

import java.util.Objects;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineManagement {

    private MachineManagement() {
        //no instantiate
    }

    private static boolean isClosed(Machine machine) {
        return machine.isClosed();
    }

    public static void checkMachineIsClosed(Machine machine) {
        if (isClosed(machine)) {
            throw new MachineIsNotClosed("Machine is not closed yet!");
        }
    }

    private static boolean isEmpty(Machine machine) {
        return machine.getVisitors().isEmpty();
    }

    public static void checkMachineEmpty(Machine machine) {
        if (!isEmpty(machine)) {
            throw new MachineIsNotEmpty("Machine is not empty yet!");
        }
    }

    public static void checkIsMachineEmptyAndClosed(Machine machine) {
        checkMachineEmpty(machine);
        checkMachineIsClosed(machine);
    }

    private static boolean isInAmusementPark(Machine machine) {
        return machine.hasAmusementPark();
    }

    public static void machineIsNotInAmusementPark(Machine machine) {
        if (!isInAmusementPark(machine)) {
            throw new MachineNotInAmusementPark("Machine hasn't been added into Amusement Park yet!");
        }
    }

    private static boolean isVisitorOnMachine(Visitor visitor) {
        return visitor.hasCurrentMachine();
    }

    private static boolean isVisitorOnThisMachine(Visitor visitor, Machine machine) {
        return isVisitorOnMachine(visitor) && Objects.equals(machine, visitor.getCurrentMachine());
    }

    public static void checkVisitorOnMachine(Visitor visitor) {
        if (isVisitorOnMachine(visitor)) {
            throw new VisitorOnMachine("Visitor is still using a machine!");
        }
    }

    private static boolean hasMachineFreeSpaces(Machine machine) {
        return machine.getFreeSpace() - machine.getVisitors().size() > 0;
    }

    public static void checkFreeSpaces(Machine machine) {
        if (!hasMachineFreeSpaces(machine)) {
            throw new MachineNotGotEnoughFreeSpaces("No remaining spaces left on this machine!");
        }
    }
}
