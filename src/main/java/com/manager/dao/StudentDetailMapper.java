package com.manager.dao;

import com.manager.vo.StudentGrade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDetailMapper {
    // 1. 根据 id 获取学生选课信息及课程信息
    List<StudentGrade> getStudentDetail(long id);
}
