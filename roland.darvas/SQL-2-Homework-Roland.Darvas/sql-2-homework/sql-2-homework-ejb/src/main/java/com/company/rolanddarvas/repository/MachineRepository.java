package com.company.rolanddarvas.repository;

import com.company.rolanddarvas.entity.Machine;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by darvasr on 2016.08.19..
 */
@Stateless
public class MachineRepository extends EntityRepository {

    public List<Machine> getMachinesAboveAge(Integer ageLimit) {
        TypedQuery<Machine> query =
                entityManager.createQuery("SELECT m FROM Machine m WHERE m.ageLimit >= :ageLimit", Machine.class);
        query.setParameter("ageLimit", ageLimit);
        return query.getResultList();
    }

    public Machine getMachineByParkId(Long parkId) {
        TypedQuery<Machine> query =
                entityManager.createQuery("SELECT m FROM Machine m WHERE m.amusementPark.id = :parkId", Machine.class);
        query.setParameter("parkId", parkId);
        return query.getSingleResult();
    }

    public List<Machine> findAll() {
        return entityManager.createQuery("SELECT m FROM Machine m", Machine.class).getResultList();
    }
}

