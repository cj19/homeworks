package com.company.rolanddarvas.entity;

import com.company.rolanddarvas.model.VisitorState;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darvasr on 2016.08.19..
 */
@Entity
@Table(name = "VISITOR")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VisitorState state;

    private Long money;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enteringDate;

    private Integer age;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VisitorState getState() {
        return state;
    }

    public void setState(VisitorState state) {
        this.state = state;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getEnteringDate() {
        return enteringDate;
    }

    public void setEnteringDate(Date enteringDate) {
        this.enteringDate = enteringDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
