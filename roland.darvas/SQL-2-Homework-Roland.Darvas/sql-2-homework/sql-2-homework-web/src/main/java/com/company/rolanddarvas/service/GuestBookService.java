package com.company.rolanddarvas.service;

import com.company.rolanddarvas.entity.GuestBook;
import com.company.rolanddarvas.entity.Visitor;
import com.company.rolanddarvas.model.dto.GuestBookDTO;
import com.company.rolanddarvas.model.dto.GuestBookListDTO;
import com.company.rolanddarvas.repository.GuestBookRepository;
import com.company.rolanddarvas.util.management.AmusementParkManagement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import java.util.Date;

/**
 * Created by darvasr on 2016.08.20..
 */
@Stateless
public class GuestBookService {

    @EJB
    private GuestBookRepository guestBookRepository;

    private VisitorService visitorService;

    private AmusementParkService amusementParkService;

    public GuestBook createGuestBook(Long visitorId, GuestBookDTO guestBookDTO) {
        Visitor visitor = visitorService.getVisitorById(visitorId);
        GuestBook guestBook = new GuestBook();

        AmusementParkManagement.checkVisitorInAmusementPark(visitor);

        guestBook.setVisitorId(visitor);
        guestBook.setAmusementParkId(visitor.getCurrentPark());
        guestBook.setRecord(guestBookDTO.getRecord());
        guestBook.setRecordDate(new Date(System.currentTimeMillis()));

        return createGuestBook(guestBook);
    }

    private GuestBook createGuestBook(GuestBook guestBook) {
        return guestBookRepository.create(guestBook);
    }

    public GuestBook getGuestBookById(Long guestBookId) {
        GuestBook guestBook = guestBookRepository.find(GuestBook.class, guestBookId);
        if (guestBook == null) {
            throw new EntityNotFoundException("Guest Book not found with this id: " + guestBookId);
        }
        return guestBook;
    }

    public GuestBookListDTO getGuestBooksByParkId(Long parkId) {
        return new GuestBookListDTO(guestBookRepository.findGuestBookByAmusementParkId(parkId));
    }

    public GuestBookListDTO getGuestBooksByVisitorId(Long visitorId) {
        return new GuestBookListDTO(guestBookRepository.findGuestBookByVisitorId(visitorId));
    }

    public GuestBookListDTO getGuestBookByVisitorAndParkId(Long visitorId, Long parkId) {
        return new GuestBookListDTO(guestBookRepository.findGuestBookByVisitorAndParkId(visitorId, parkId));
    }

    public GuestBookListDTO getAllGuestBooks() {
        return new GuestBookListDTO(guestBookRepository.findAll());
    }

    public GuestBook removeGuestBook(Long guestBookId) {
        GuestBook guestBook = guestBookRepository.delete(GuestBook.class, guestBookId);
        if (guestBook == null) {
            throw new EntityNotFoundException("Guest Book not found with this id, cant delete : " + guestBookId);
        }
        return guestBook;
    }

    public GuestBook updateGuestBook(Long guestBookId, GuestBookDTO guestBookDTO) {
        GuestBook guestBook = guestBookRepository.find(GuestBook.class, guestBookId);
        guestBook.setId(guestBookId);

        guestBook.setAmusementParkId(amusementParkService.getAmusementParkById(guestBookDTO.getAmusementParkId()));
        guestBook.setVisitorId(visitorService.getVisitorById(guestBookDTO.getVisitorId()));

        guestBook.setRecordDate(new Date(System.currentTimeMillis()));
        guestBook.setRecord(guestBookDTO.getRecord());

        return updateGuestBook(guestBook);
    }

    public GuestBook updateGuestBook(GuestBook guestBook) {
        return guestBookRepository.update(guestBook);
    }

    @Inject
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Inject
    public void setAmusementParkService(AmusementParkService amusementParkService) {
        this.amusementParkService = amusementParkService;
    }
}
