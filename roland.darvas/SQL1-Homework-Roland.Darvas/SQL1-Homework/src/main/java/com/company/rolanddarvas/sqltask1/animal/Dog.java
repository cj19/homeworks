package com.company.rolanddarvas.sqltask1.animal;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Dog.ability", query = "SELECT d FROM Dog d WHERE :ability MEMBER OF d.abilities")
public class Dog extends Mammal {

    public Dog(Long id, MammalType type, String name, List habitat) {
        super(id, type, name, habitat);
    }

    public Dog() {
        //default instantion
    }

}
