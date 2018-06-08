package com.manager.domain;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

@Component
public class SC {

    private long Sno;

    private long Cno;

    @Min(0)
    private float Grade;

    public long getSno() {
        return Sno;
    }
    public void setSno(long sno) {
        Sno = sno;
    }
    public long getCno() {
        return Cno;
    }
    public void setCno(long cno) {
        Cno = cno;
    }
    public float getGrade() {
        return Grade;
    }
    public void setGrade(float grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "SC{" +
                "Sno=" + Sno +
                ", Cno=" + Cno +
                ", Grade=" + Grade +
                ", studentList=" + '}';
    }
}
