package com.company.rolanddarvas.sqltask1.animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
public class Mammal extends Creature {

    @Column(name = "animal_type", nullable = false)
    private MammalType type;

    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Ability> abilities = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Mammal(Long id, MammalType type, String name) {
        super(id);
        this.type = type;
        this.name = name;
        this.creationDate = new Date(System.currentTimeMillis());
    }

    public Mammal() {
        //default instantion
    }

    public MammalType getType() {
        return type;
    }

    public void setType(MammalType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
