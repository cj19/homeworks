package com.company.rolanddarvas.service;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.model.dto.MachineDTO;
import com.company.rolanddarvas.model.dto.MachineListDTO;
import com.company.rolanddarvas.model.dto.VisitorListDTO;
import com.company.rolanddarvas.repository.MachineRepository;
import com.company.rolanddarvas.util.management.AmusementParkManagement;
import com.company.rolanddarvas.util.management.MachineManagement;
import com.company.rolanddarvas.util.utility.Utility;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

/**
 * Created by darvasr on 2016.08.20..
 */
@Stateless
public class MachineService {

    @EJB
    private MachineRepository machineRepository;

    private AmusementParkService amusementParkService;

    public Machine createMachine(MachineDTO machineDTO) {
        Machine machine = new Machine();
        machine.setFancyName(machineDTO.getFancyName());
        machine.setSize(machineDTO.getSize());
        machine.setPrice(machineDTO.getPrice());
        machine.setTicketPrice(machineDTO.getTicketPrice());
        machine.setRequiredSpace(machineDTO.getRequiredSpace());
        machine.setFreeSpace(machineDTO.getFreeSpace());
        machine.setType(machineDTO.getType());
        machine.setAgeLimit(machineDTO.getAgeLimit());
        machine.setClosed(false);

        return createMachine(machine);

    }

    private Machine createMachine(Machine machine) {
        return machineRepository.create(machine);
    }

    public Machine getMachineById(Long machineId) {
        Machine machine = getMachineById(machineId);
        if (machine == null) {
            throw new EntityNotFoundException("Machine not found with this id: " + machineId);
        }
        return machine;
    }

    public Machine closeMachineById(Long machineId) {
        Machine machine = getMachineById(machineId);
        MachineManagement.checkMachineIsClosed(machine);
        MachineManagement.checkMachineEmpty(machine);

        machine.setClosed(true);

        return updateMachine(machine);
    }

    public Machine openMachineById(Long machineId) {
        Machine machine = getMachineById(machineId);
        MachineManagement.checkMachineIsClosed(machine);

        machine.setClosed(false);

        return updateMachine(machine);
    }

    public Machine updateMachine(Long machineId, MachineDTO machineDTO) {
        Machine currentMachine = getMachineById(machineId);

        currentMachine.setFancyName(machineDTO.getFancyName());
        currentMachine.setAgeLimit(machineDTO.getAgeLimit());
        currentMachine.setType(machineDTO.getType());
        currentMachine.setFreeSpace(machineDTO.getFreeSpace());
        currentMachine.setSize(machineDTO.getSize());
        currentMachine.setPrice(machineDTO.getPrice());
        currentMachine.setTicketPrice(machineDTO.getTicketPrice());
        currentMachine.setClosed(machineDTO.getClosed());

        return updateMachine(currentMachine);
    }

    public Machine updateMachine(Machine machine) {
        return machineRepository.update(machine);
    }

    public Machine removeMachine(Long machineId) {
        Machine machine = getMachineById(machineId);
        MachineManagement.checkIsMachineEmptyAndClosed(machine);
        AmusementParkManagement.transferFunds(machine);

        AmusementParkManagement.removeMachineFromAmusementPark(machine);

        return machineRepository.delete(Machine.class, machineId);

    }

    public Machine addToAmusementParkById(Long machineId, Long amusementParkId) {
        Machine machine = machineRepository.find(Machine.class, machineId);
        MachineManagement.machineIsNotInAmusementPark(machine);

        AmusementPark amusementPark = amusementParkService.getAmusementParkById(amusementParkId);
        AmusementParkManagement.checkParkHasFreeLand(amusementPark, machine);

        AmusementParkManagement.buyMachine(amusementPark, machine);
        Utility.addMachineToPark(machine, amusementPark);
        amusementParkService.updateAmusementPark(amusementPark);

        return updateMachine(machine);

    }

    public MachineListDTO getMachinesAboveAgeLimit(Integer ageLimit) {
        return new MachineListDTO(machineRepository.getMachinesAboveAge(ageLimit));
    }

    public VisitorListDTO getVisitorsByMachineId(Long machineId) {
        return new VisitorListDTO(getMachineById(machineId).getVisitors());
    }

    public MachineListDTO getAllMachines() {
        return new MachineListDTO(machineRepository.findAll());
    }

    @Inject
    public void setAmusementParkService(AmusementParkService amusementParkService) {
        this.amusementParkService = amusementParkService;
    }
}
