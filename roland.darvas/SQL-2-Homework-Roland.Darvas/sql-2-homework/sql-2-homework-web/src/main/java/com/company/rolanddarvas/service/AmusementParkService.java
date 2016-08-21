package com.company.rolanddarvas.service;

import com.company.rolanddarvas.entity.AmusementPark;
import com.company.rolanddarvas.model.dto.*;
import com.company.rolanddarvas.repository.AmusementParkRepository;
import com.company.rolanddarvas.util.management.AmusementParkManagement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;

/**
 * Created by darvasr on 2016.08.20..
 */
@Stateless
public class AmusementParkService {

    @EJB
    private AmusementParkRepository parkRepository;

    public AmusementPark createAmusementPark(AmusementParkDTO amusementParkDTO) {
        AmusementPark amusementPark = new AmusementPark();
        amusementPark.setAddress(amusementParkDTO.getAddress());
        amusementPark.setFund(amusementParkDTO.getFund());
        amusementPark.setLand(amusementParkDTO.getLand());
        amusementPark.setName(amusementParkDTO.getName());
        amusementPark.setTicketPrice(amusementParkDTO.getTicketPrice());

        return createAmusementPark(amusementPark);
    }

    private AmusementPark createAmusementPark(AmusementPark amusementPark) {
        return parkRepository.create(amusementPark);
    }

    public AmusementPark getAmusementParkById(Long parkId) {
        AmusementPark amusementPark = parkRepository.find(AmusementPark.class, parkId);
        if (amusementPark == null) {
            throw new EntityNotFoundException("No Amusement Park found with this id: "+parkId);
        }
        return amusementPark;
    }


    public AmusementPark updateAmusementPark(Long parkId, AmusementParkDTO amusementParkDTO) {
        AmusementPark currentAmusementPark = getAmusementParkById(parkId);

        AmusementPark amusementPark = new AmusementPark();

        amusementPark.setId(parkId);

        amusementPark.setMachines(currentAmusementPark.getMachines());
        amusementPark.setVisitors(currentAmusementPark.getVisitors());
        amusementPark.setAddress(amusementParkDTO.getAddress());
        amusementPark.setFund(amusementParkDTO.getFund());
        amusementPark.setName(amusementParkDTO.getName());
        amusementPark.setTicketPrice(amusementParkDTO.getTicketPrice());
        amusementPark.setLand(amusementParkDTO.getLand());

        return updateAmusementPark(amusementPark);
    }

    public AmusementPark updateAmusementPark(AmusementPark amusementPark) {
        return parkRepository.update(amusementPark);
    }

    public AmusementPark removeAmusementParkById(Long parkId) {
        AmusementPark amusementPark = getAmusementParkById(parkId);
        AmusementParkManagement.checkEmptyPark(amusementPark);
        parkRepository.delete(AmusementPark.class, amusementPark.getId());
        return amusementPark;
    }

    public MachineListDTO getAllMachines(Long parkId) {
        return new MachineListDTO(getAmusementParkById(parkId).getMachines());
    }

    public VisitorListDTO getAllVisitors(Long parkId) {
        return new VisitorListDTO(getAmusementParkById(parkId).getVisitors());
    }

    public AmusementParkListDTO getAmusementParkList() {
        return new AmusementParkListDTO(parkRepository.findAll());
    }

    public VisitorReportDTO getIdleVisitors(Long parkId) {
        return new VisitorReportDTO(parkRepository.getIdleVisitors(parkId));
    }
}
