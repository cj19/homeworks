package com.company.rolanddarvas.service;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.entity.Machine;
import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.model.dto.VisitorDTO;
import com.company.rolanddarvas.model.dto.VisitorListDTO;
import com.company.rolanddarvas.repository.VisitorRepository;
import com.company.rolanddarvas.util.management.AmusementParkManagement;
import com.company.rolanddarvas.util.management.MachineManagement;
import com.company.rolanddarvas.util.management.VisitorManagement;
import com.company.rolanddarvas.util.utility.Utility;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

/**
 * Created by darvasr on 2016.08.20..
 */
@Stateless
public class VisitorService {

    @EJB
    private VisitorRepository visitorRepository;

    private MachineService machineService;

    private AmusementParkService amusementParkService;

    public Visitor createVisitor(VisitorDTO visitorDTO) {
        Visitor visitor = new Visitor();
        visitor.setMoney(visitorDTO.getMoney());
        visitor.setAge(visitorDTO.getAge());

        return createVisitor(visitor);
    }

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.create(visitor);
    }


    public Visitor getVisitorById(Long visitorId) {
        Visitor visitor = visitorRepository.find(Visitor.class, visitorId);
        if (visitor == null) {
            throw new EntityNotFoundException("Visitor not found with this id: " + visitorId);
        }
        return visitor;
    }


    public Visitor updateVisitor(Long visitorId, VisitorDTO visitorDTO) {
        Visitor currentVisitor = getVisitorById(visitorId);

        currentVisitor.setAge(visitorDTO.getAge());
        currentVisitor.setMoney(visitorDTO.getMoney());

        return updateVisitor(currentVisitor);

    }

    private Visitor updateVisitor(Visitor visitor) {
        return visitorRepository.update(visitor);
    }

    public Visitor addVisitorToMachine(Long visitorId, Long machineId) {
        Visitor visitor = getVisitorById(visitorId);
        Machine machine = machineService.getMachineById(machineId);

        MachineManagement.checkMachineIsNotClosed(machine);
        AmusementParkManagement.checkMachineAndVisitorAreInTheSamePark(visitor, machine);
        MachineManagement.checkVisitorNotOnMachine(visitor);
        MachineManagement.checkFreeSpaces(machine);
        VisitorManagement.chechAgeLimit(machine, visitor);

        VisitorManagement.payMachineTicket(machine, visitor);
        Utility.addVisitorToMachine(machine, visitor);

        machineService.updateMachine(machine);
        return updateVisitor(visitor);

    }

    public Visitor removeFromMachine(Long visitorId) {
        Visitor visitor = getVisitorById(visitorId);
        MachineManagement.checkVisitorOnMachine(visitor);

        Machine machine = visitor.getCurrentMachine();
        Utility.removeVisitorFromMachine(machine, visitor);

        machineService.updateMachine(machine);
        return updateVisitor(visitor);
    }


    public Visitor enterAmusementPark(Long visitorId, Long parkId) {
        Visitor visitor = getVisitorById(visitorId);
        AmusementParkManagement.checkVisitorNotInAmusementPark(visitor);

        AmusementPark amusementPark = amusementParkService.getAmusementParkById(parkId);

        VisitorManagement.payEntryTicket(amusementPark, visitor);
        Utility.addVisitorToPark(visitor, amusementPark);

        amusementParkService.updateAmusementPark(amusementPark);
        return updateVisitor(visitor);
    }

    public Visitor leaveAmusementPark(Long visitorId) {
        Visitor visitor = getVisitorById(visitorId);
        AmusementParkManagement.checkVisitorInAmusementPark(visitor);
        MachineManagement.checkVisitorNotOnMachine(visitor);

        AmusementPark amusementPark = visitor.getCurrentPark();

        Utility.removeVisitorFromPark(visitor, amusementPark);

        amusementParkService.updateAmusementPark(amusementPark);
        return updateVisitor(visitor);
    }

    public VisitorListDTO getActiveVisitors() {
        return new VisitorListDTO(visitorRepository.getActiveVisitor());
    }

    public VisitorListDTO getVisitorByRestState() {
        return new VisitorListDTO(visitorRepository.getVisitorByRestState());
    }

    public VisitorListDTO getVisitorByOnMachineState() {
        return new VisitorListDTO(visitorRepository.getVisitorByOnMachineState());
    }

    public VisitorListDTO getAllVisitors() {
        return new VisitorListDTO(visitorRepository.findAll());
    }

    @Inject
    public void setMachineService(MachineService machineService) {
        this.machineService = machineService;
    }

    @Inject
    public void setAmusementParkService(AmusementParkService amusementParkService) {
        this.amusementParkService = amusementParkService;
    }
}
