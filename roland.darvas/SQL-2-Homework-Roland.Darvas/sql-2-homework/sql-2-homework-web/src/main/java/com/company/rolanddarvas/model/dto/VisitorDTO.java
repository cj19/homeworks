package com.company.rolanddarvas.model.dto;

/**
 * Created by darvasr on 2016.08.21..
 */
public class VisitorDTO {

    private Long money;

    private Integer age;

    public VisitorDTO(Long money, Integer age) {
        this.money = money;
        this.age = age;
    }

    public VisitorDTO() {
        //Default constructor
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
