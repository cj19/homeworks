package com.company.rolanddarvas.model.dto;

import com.company.rolanddarvas.entity.Machine;

import java.util.List;

/**
 * Created by darvasr on 2016.08.21..
 */
public class MachineListDTO {

    private List<Machine> machines;

    public MachineListDTO(List<Machine> machines) {
        this.machines = machines;
    }

    public MachineListDTO() {
        //Default constructor
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}
