package com.manager.service.impl;

import com.manager.dao.StudentDetailMapper;
import com.manager.service.StudentDetailService;
import com.manager.vo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {
    @Autowired
    StudentDetailMapper studentDetailMapper;

    @Override
    public List<StudentGrade> getStudentDetail(long id) {
        return studentDetailMapper.getStudentDetail(id);
    }
}
