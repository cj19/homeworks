package com.company.rolanddarvas.sql_task1.animal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author darvasr @email:darvas.roland@gmail.com
 */
@MappedSuperclass
public class Creature {

    @Id
    @GeneratedValue
    private Long id;

    public Creature(Long id) {
        this.id = id;
    }

    public Creature() {
        //default constuctor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
