package com.company.rolanddarvas.sqltask1.animal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Ability.getId", 
        query = "SELECT a from Ability a inner join a.animal animals WHERE animals.id = :id")
public class Ability {

    @Id
    @GeneratedValue
    private Long id;

    private String abilityName;

    private String descripton;

    @ManyToMany
    @JoinTable(name = "animal_abilities", joinColumns = @JoinColumn(name = "abilities_fk"),
            inverseJoinColumns = @JoinColumn(name = "mammals_fk"))
    private List<Mammal> animal;

    public Ability(Long id, String abilityName, String descripton) {
        this.id = id;
        this.abilityName = abilityName;
        this.descripton = descripton;
        this.animal = new ArrayList<>();
    }

    public Ability() {
        //default instantion
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public List<Mammal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Mammal> animal) {
        this.animal = animal;
    }

    
}
