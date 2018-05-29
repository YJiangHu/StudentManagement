package com.manager.domain;

import org.springframework.stereotype.Component;

@Component
public class Course {
    private long id;
    private String name;
    private float credit;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getCredit() {
        return credit;
    }
    public void setCredit(float credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
