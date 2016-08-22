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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitorDTO that = (VisitorDTO) o;

        if (!money.equals(that.money)) return false;
        return age.equals(that.age);

    }

    @Override
    public int hashCode() {
        int result = money.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}
