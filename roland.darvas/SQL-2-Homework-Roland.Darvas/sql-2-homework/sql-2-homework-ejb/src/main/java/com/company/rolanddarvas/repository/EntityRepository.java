package com.company.rolanddarvas.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by darvasr on 2016.08.19..
 */
@Stateless
public class EntityRepository {

    @PersistenceContext(unitName = "AmusementParkPU")
    protected EntityManager entityManager;

    public <T> void create(T entity) {
        entityManager.persist(entity);
    }

    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T> T find(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    public <T> void delete(Class<T> clazz, Long id) {
        T entity = find(clazz, id);
        entityManager.remove(entity);
    }

}
