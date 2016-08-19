package com.company.rolanddarvas.sqltask1.animal;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@Entity
@NamedQuery(name = "Dolphin.creationDate", query = "SELECT d FROM Dolphin d WHERE d.creationDate < :date")
public class Dolphin extends Mammal {

    public Dolphin(Long id, MammalType type, String name, List habitat) {
        super(id, type, name, habitat);
    }

    public Dolphin() {
        //default instantion
    }
}
