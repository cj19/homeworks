package com.company.rolanddarvas.sqltask1.animal;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Grizzly.type", query = "SELECT b FROM Grizzly b WHERE b.type "
        + "= com.company.rolanddarvas.sqltask1.animal.MammalType.PREDATOR")
public class Grizzly extends Mammal {

    public Grizzly(Long id, MammalType type, String name, List habitat) {
        super(id, type, name, habitat);
    }

    public Grizzly() {
        //default instantion
    }

}
