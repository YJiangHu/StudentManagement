package com.manager.dao;

import com.manager.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    // 1. 获取所有课程信息
    List<Course> getAllCourse();
}
