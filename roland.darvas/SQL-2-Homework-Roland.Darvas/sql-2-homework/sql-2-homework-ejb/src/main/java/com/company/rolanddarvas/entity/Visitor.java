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

    @ManyToOne(targetEntity = AmusementPark.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "current_park_id")
    private AmusementPark currentPark;

    @ManyToOne(targetEntity = Machine.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "current_machine_id")
    private Machine currentMachine;

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

    public AmusementPark getCurrentPark() {
        return currentPark;
    }

    public void setCurrentPark(AmusementPark currentParkId) {
        this.currentPark = currentParkId;
    }

    public Machine getCurrentMachine() {
        return currentMachine;
    }

    public void setCurrentMachine(Machine currentMachine) {
        this.currentMachine = currentMachine;
    }

    public boolean hasAmusementPark() {
        return currentPark != null;
    }

    public boolean hasCurrentMachine() {
        return currentMachine != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Visitor visitor = (Visitor) o;
        if (!id.equals(visitor.id)){
            return false;
        }
        if (state != visitor.state){
            return false;
        }
        if (!money.equals(visitor.money)){
            return false;
        }
        if (!enteringDate.equals(visitor.enteringDate)){
            return false;
        }
        if (!age.equals(visitor.age)){
            return false;
        }
        if (!active.equals(visitor.active)){
            return false;
        }
        if (currentPark != null ? !currentPark.equals(visitor.currentPark) : visitor.currentPark != null){
            return false;
        }
        return currentMachine != null ? currentMachine.equals(visitor.currentMachine) : visitor.currentMachine == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + money.hashCode();
        result = 31 * result + enteringDate.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + active.hashCode();
        result = 31 * result + (currentPark != null ? currentPark.hashCode() : 0);
        result = 31 * result + (currentMachine != null ? currentMachine.hashCode() : 0);
        return result;
    }
}
