package com.company.rolanddarvas.repository;

import com.company.rolanddarvas.entity.Visitor;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by darvasr on 2016.08.19..
 */
@Stateless
public class VisitorRepository extends EntityRepository {

    public List<Visitor> getActiveVisitor() {
        TypedQuery<Visitor> query =
                entityManager.createQuery("SELECT v FROM Visitor v WHERE v.active = true ", Visitor.class);
        return query.getResultList();
    }

    public List<Visitor> getVisitorByRestState() {
        TypedQuery<Visitor> query =
                entityManager
                        .createQuery("SELECT v FROM Visitor v WHERE v.state = com.company.rolanddarvas.model.VisitorState.REST", Visitor.class);
        return query.getResultList();
    }

    public List<Visitor> getVisitorByOnMachineState() {
        TypedQuery<Visitor> query =
                entityManager
                        .createQuery("SELECT v FROM Visitor v WHERE v.state = com.company.rolanddarvas.model.VisitorState.ON_MACHINE", Visitor.class);
        return query.getResultList();
    }

    public List<Visitor> findAll() {
        return entityManager.createQuery("SELECT v FROM Visitor v", Visitor.class).getResultList();
    }
}
