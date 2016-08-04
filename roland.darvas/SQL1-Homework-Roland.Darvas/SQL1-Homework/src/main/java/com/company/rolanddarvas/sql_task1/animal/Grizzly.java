package com.company.rolanddarvas.sql_task1.animal;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Grizzly.type", query = "SELECT b FROM Grizzly b WHERE b.type "
        + "= com.company.rolanddarvas.sql_task1.animal.MammalType.PREDATOR")
public class Grizzly extends Mammal {

    public Grizzly(Long id, MammalType type, String name) {
        super(id, type, name);
    }

    public Grizzly() {
        //default instantion
    }

}
