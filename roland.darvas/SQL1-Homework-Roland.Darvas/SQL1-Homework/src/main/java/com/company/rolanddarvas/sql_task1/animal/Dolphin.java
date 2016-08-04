package com.company.rolanddarvas.sql_task1.animal;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Dolphin.creationDate", query = "SELECT d FROM Dolphin d WHERE d.creationDate < :date")
public class Dolphin extends Mammal {

    public Dolphin(Long id, MammalType type, String name) {
        super(id, type, name);
    }

    public Dolphin() {
        //default instantion
    }
}
