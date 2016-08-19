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

    public List<GuestBook> getVisitorAfterRecordDate(Date recordDate) {
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g from GuestBook g WHERE g.recordDate > :recordDate", GuestBook.class);
        return query.getResultList();
    }

    public List<GuestBook> getGuestBookByVisitorId(Long visitorId){
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g FROM GuestBook g WHERE g.visitorId = :visitorId", GuestBook.class);
        query.setParameter("visitorId", visitorId);
        return query.getResultList();
    }

    public List<GuestBook> getGuestBookByAmusementParkId(Long amusementParkId){
        TypedQuery<GuestBook> query =
                entityManager.createQuery("SELECT g FROM GuestBook g WHERE g.visitorId = :amusementParkId", GuestBook.class);
        query.setParameter("amusementParkId", amusementParkId);
        return query.getResultList();
    }

}
