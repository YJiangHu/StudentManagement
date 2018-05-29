package com.manager.service;

import com.manager.vo.StudentGrade;

import java.util.List;

public interface StudentDetailService {
    List<StudentGrade> getStudentDetail(long id);
}
