package com.company.rolanddarvas.sqltask1.animal;

import java.util.ArrayList;
import java.util.Arrays;
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
        Tiger tiger = new Tiger(1L, MammalType.PREDATOR, "tigris", new ArrayList(Arrays.asList("jungle")));
        Dolphin dolphin = new Dolphin(2L, MammalType.HERBIVORE, "delfin", new ArrayList(Arrays.asList("ocean", "sea")));
        Grizzly bear = new Grizzly(3L, MammalType.PREDATOR, "yogi bear", new ArrayList(Arrays.asList("forest", "USA")));
        Dog dog = new Dog(4L, MammalType.PREDATOR, "doge", new ArrayList(Arrays.asList("Japan", "Moon")));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("getMammals");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        persistAbilities(em, stealth);
        persistAbilities(em, swim);
        persistAbilities(em, run);
        
        persistAnimals(em, tiger);
        persistAnimals(em, bear);
        persistAnimals(em, dolphin);
        persistAnimals(em, dolphin);
        
        setAbilityToMammal(tiger, run);
        setAbilityToMammal(tiger, swim);
        setAbilityToMammal(tiger, stealth);
        setAbilityToMammal(dolphin, swim);
        setAbilityToMammal(bear, run);          
        setAbilityToMammal(dog, run);
        setAbilityToMammal(dog, stealth);
                
        setMammalToAbility(stealth, tiger);
        setMammalToAbility(stealth, dog);
        setMammalToAbility(swim, tiger);
        setMammalToAbility(swim, dolphin);
        setMammalToAbility(run, tiger);
        setMammalToAbility(run, bear);
        setMammalToAbility(run, dog);
        
        mergeAnimals(em, tiger);
        mergeAnimals(em, bear);
        mergeAnimals(em, dolphin);
        mergeAnimals(em, dog);
        
        mergeAbility(em, stealth);
        mergeAbility(em, swim);
        mergeAbility(em, run);
        tx.commit();

        abilityQuery(em, 1);

        tiger = tigerQuery(em);

        dolphin = dolphinQuery(em, new Date(System.currentTimeMillis()));

        bear = bearQuery(em);

        dog = dogQuery(em);
        LOG.log(Level.INFO, dog.toString());
        LOG.log(Level.INFO, bear.toString());
        LOG.log(Level.INFO, dolphin.toString());
        LOG.log(Level.INFO, tiger.toString());
        em.close();
        emf.close();
    }

    private static void mergeAbility(EntityManager em, Ability ability) {
        em.merge(ability);
    }

    private static void mergeAnimals(EntityManager em, Mammal mammal) {
        em.merge(mammal);
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

    private static Dolphin dolphinQuery(EntityManager em, Date date) {
        Dolphin dolphin;
        TypedQuery<Dolphin> dolphinQuery = em.createNamedQuery("Dolphin.creationDate", Dolphin.class);
        dolphinQuery.setParameter("date", date);
        dolphin = dolphinQuery.getSingleResult();
        return dolphin;
    }

    private static Tiger tigerQuery(EntityManager em) {
        Tiger tiger;
        tiger = em.createNamedQuery("Tiger.name", Tiger.class).getSingleResult();
        return tiger;
    }

    private static void abilityQuery(EntityManager em, Integer id) {
        TypedQuery<Ability> query = em.createNamedQuery("Ability.getId", Ability.class);
        query.setParameter("id", id);
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

    private static void setMammalToAbility(Ability ability, Mammal mammal) {
        ability.getAnimal().add(mammal);
    }

    private static void setAbilityToMammal(Mammal mammal, Ability ability) {
        mammal.getAbilities().add(ability);
    }

    private static void persistAbilities(EntityManager em, Ability ability) {
        em.persist(ability);
    }
    
    private static void persistAnimals(EntityManager em, Mammal mammal){
       em.persist(mammal);
    }

    private static Ability createAbility(Long id, String abilityName, String description) {
        return new Ability(id, abilityName, description);
    }
}
