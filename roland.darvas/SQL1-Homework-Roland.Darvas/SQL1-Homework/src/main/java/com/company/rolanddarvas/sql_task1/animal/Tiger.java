package com.company.rolanddarvas.sql_task1.animal;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Tiger.name", query = "SELECT t FROM Tiger t WHERE t.name='tigris'")
public class Tiger extends Mammal {

    public Tiger(Long id, MammalType type, String name) {
        super(id, type, name);
    }

    public Tiger() {
        //default instantion
    }
}
