package com.company.rolanddarvas.repository;

import com.company.rolanddarvas.entity.GuestBook;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by darvasr on 2016.08.19..
 */
@Stateless
public class GuestBookRepository extends EntityRepository {

    public List<GuestBook> findVisitorAfterRecordDate(Date recordDate) {
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g from GuestBook g WHERE g.recordDate > :recordDate", GuestBook.class);
        query.setParameter("recordDate", recordDate);
        return query.getResultList();
    }

    public List<GuestBook> findGuestBookByVisitorId(Long visitorId){
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g FROM GuestBook g WHERE g.visitorId.id = :visitorId", GuestBook.class);
        query.setParameter("visitorId", visitorId);
        return query.getResultList();
    }

    public List<GuestBook> findGuestBookByAmusementParkId(Long amusementParkId){
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g FROM GuestBook g WHERE g.amusementParkId.id = :amusementParkId", GuestBook.class);
        query.setParameter("amusementParkId", amusementParkId);
        return query.getResultList();
    }

    public List<GuestBook> findGuestBookByVisitorAndParkId(Long visitorId, Long parkId) {
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g FROM GuestBook g WHERE g.visitorId.id = :visitorId AND g.amusementParkId.id = :parkId", GuestBook.class);
        query.setParameter("visitorId", visitorId);
        query.setParameter("parkId", parkId);
        return query.getResultList();
    }

    public List<GuestBook> findAll(){
        return entityManager.createQuery("SELECT g FROM GuestBook g", GuestBook.class).getResultList();
    }
}
