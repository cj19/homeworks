package com.company.rolanddarvas.sqltask1.animal;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Tiger.name", query = "SELECT t FROM Tiger t WHERE t.name='tigris'")
public class Tiger extends Mammal {

    public Tiger(Long id, MammalType type, String name, List habitat) {
        super(id, type, name, habitat);
    }

    public Tiger() {
        //default instantion
    }
}
