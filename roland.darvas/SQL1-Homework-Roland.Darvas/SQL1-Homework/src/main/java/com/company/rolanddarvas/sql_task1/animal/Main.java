package com.company.rolanddarvas.sql_task1.animal;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private Main() {
        //not to instantiate
    }

    public static void main(String[] args) {

        Ability stealth = createAbility(1L, "stealth", "stealth");
        Ability swim = createAbility(2L, "swim", "swim");
        Ability run = createAbility(3L, "run", "run");
        Tiger tiger = new Tiger(1L, MammalType.PREDATOR, "tigris");
        Dolphin dolphin = new Dolphin(2L, MammalType.HERBIVORE, "delfin");
        Grizzly bear = new Grizzly(3L, MammalType.PREDATOR, "yogi bear");
        Dog dog = new Dog(4L, MammalType.PREDATOR, "doge");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("getMammals");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        persistAbilities(em, stealth, swim, run);
        persistAnimals(em, tiger, dolphin, bear, dog);
        setAbilitiesToAnimals(tiger, run, swim, stealth, dolphin, bear, dog);
        setAnimalsToAbilities(stealth, tiger, dog, swim, dolphin, run, bear);
        tiger = em.merge(tiger);
        dog = em.merge(dog);
        bear = em.merge(bear);
        dolphin = em.merge(dolphin);
        stealth = em.merge(stealth);
        run = em.merge(run);
        swim = em.merge(swim);
        tx.commit();

        abilityQuery(em);

        tiger = tigerQuery(em);

        dolphin = dolphinQuery(em);

        bear = bearQuery(em);

        dog = dogQuery(em);
        LOG.log(Level.INFO, dog.toString());
        LOG.log(Level.INFO, bear.toString());
        LOG.log(Level.INFO, dolphin.toString());
        LOG.log(Level.INFO, tiger.toString());
        em.close();
        emf.close();
    }

    private static Dog dogQuery(EntityManager em) {
        Dog dog;
        TypedQuery<Dog> dogeQuery = em.createNamedQuery("Dog.ability", Dog.class);
        dogeQuery.setParameter("ability", new Ability(3L, "run", "run"));
        dog = dogeQuery.getSingleResult();
        return dog;
    }

    private static Grizzly bearQuery(EntityManager em) {
        Grizzly bear;
        bear = em.createNamedQuery("Grizzly.type", Grizzly.class).getSingleResult();
        return bear;
    }

    private static Dolphin dolphinQuery(EntityManager em) {
        Dolphin dolphin;
        TypedQuery<Dolphin> dolphinQuery = em.createNamedQuery("Dolphin.creationDate", Dolphin.class);
        dolphinQuery.setParameter("date", new Date(System.currentTimeMillis()));
        dolphin = dolphinQuery.getSingleResult();
        return dolphin;
    }

    private static Tiger tigerQuery(EntityManager em) {
        Tiger tiger;
        tiger = em.createNamedQuery("Tiger.name", Tiger.class).getSingleResult();
        return tiger;
    }

    private static void abilityQuery(EntityManager em) {
        TypedQuery<Ability> query = em.createNamedQuery("Ability.getId", Ability.class);
        query.setParameter("id", 1);
        List<Ability> ab = query.getResultList();
        ab.stream().map((ability) -> {
            LOG.log(Level.INFO, ability.getAbilityName());
            return ability;
        }).forEach((ability) -> {
            ability.getAnimal().stream().forEach((animal) -> {
                LOG.log(Level.INFO, animal.getName());
            });
        });
    }

    private static void setAnimalsToAbilities(Ability stealth, Tiger tiger, Dog dog, Ability swim, Dolphin dolphin, Ability run, Grizzly bear) {
        stealth.getAnimal().add(tiger);
        stealth.getAnimal().add(dog);
        swim.getAnimal().add(tiger);
        swim.getAnimal().add(dolphin);
        run.getAnimal().add(tiger);
        run.getAnimal().add(bear);
        run.getAnimal().add(dog);
    }

    private static void setAbilitiesToAnimals(Tiger tiger, Ability run, Ability swim, Ability stealth, Dolphin dolphin, Grizzly bear, Dog dog) {
        tiger.getAbilities().add(run);
        tiger.getAbilities().add(swim);
        tiger.getAbilities().add(stealth);
        dolphin.getAbilities().add(swim);
        bear.getAbilities().add(run);
        dog.getAbilities().add(run);
        dog.getAbilities().add(stealth);
    }

    private static void persistAbilities(EntityManager em, Ability stealth, Ability swim, Ability run) {
        em.persist(stealth);
        em.persist(swim);
        em.persist(run);
    }
    
    private static void persistAnimals(EntityManager em, Tiger tiger, Dolphin dolphin, Grizzly bear, Dog dog){
       em.persist(tiger);
       em.persist(dolphin);
       em.persist(bear);
       em.persist(dog);
       
    }

    private static Ability createAbility(Long id, String abilityName, String description) {
        return new Ability(id, abilityName, description);
    }
}
