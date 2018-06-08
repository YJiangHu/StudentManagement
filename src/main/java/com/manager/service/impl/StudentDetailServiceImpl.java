package com.manager.service.impl;

import com.manager.dao.StudentDetailMapper;
import com.manager.domain.Course;
import com.manager.domain.SC;
import com.manager.service.StudentDetailService;
import com.manager.vo.StudentGrade;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public StudentGrade getDetail(long cno, long sno) {
        return studentDetailMapper.getDetail(cno, sno);
    }

    @Override
    public int deleteDetail(long cno, long sno) {
        return studentDetailMapper.deleteDetail(cno, sno);
    }

    @Override
    public int updateDetail(long cno, long sno, float grade) {
        return studentDetailMapper.updateDetail(cno, sno, grade);
    }

    @Override
    public int insertDetail(SC sc) {
        return studentDetailMapper.insertDetail(sc);
    }

    @Override
    public List<Course> getCourseList() {
        return studentDetailMapper.getCourseList();
    }
}
