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

    public List<Machine> getMachinesAboveAge(Integer ageLimit){
        TypedQuery<Machine> query =
                entityManager.createQuery("SELECT m FROM Machine m WHERE m.ageLimit >= :ageLimit", Machine.class);
        query.setParameter("ageLimit", ageLimit);
        return query.getResultList();
    }
}

