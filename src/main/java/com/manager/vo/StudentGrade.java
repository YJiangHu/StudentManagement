package com.manager.vo;

import com.manager.domain.Course;
import com.manager.domain.SC;
import org.springframework.stereotype.Component;

@Component
public class StudentGrade {

    private Course course;
    private SC sc;

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public SC getSc() {
        return sc;
    }
    public void setSc(SC sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "SCInfo{" +
                "course=" + course +
                ", sc=" + sc +
                '}';
    }
}
