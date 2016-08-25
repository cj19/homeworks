package com.company.rolanddarvas.repository;

import com.company.rolanddarvas.entity.AmusementPark;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by darvasr on 2016.08.19..
 */
@Stateless
public class AmusementParkRepository extends EntityRepository {

    public List<AmusementPark> getAmusementParkByAddressId(Long addressId){
        TypedQuery<AmusementPark> query =
                entityManager.createQuery("SELECT a FROM AmusementPark a WHERE a.id = :addressId", AmusementPark.class);
        query.setParameter("addressId", addressId);
        return query.getResultList();
    }

    public List<AmusementPark> findAll(){
        return entityManager.createQuery("SELECT a FROM AmusementPark a", AmusementPark.class).getResultList();
    }

    public Long getIdleVisitors(Long parkId){
        return entityManager
                .createQuery("SELECT COUNT(v.id) FROM Visitor v WHERE v.currentPark.id = :parkId AND v.currentMachine IS NULL AND v.active = FALSE", Long.class)
                .setParameter("parkId", parkId).getSingleResult();
    }
}
