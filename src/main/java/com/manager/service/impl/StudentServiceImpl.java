package com.manager.service.impl;

import com.manager.dao.StudentMapper;
import com.manager.domain.Student;
import com.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getStudent(long id) {
        return studentMapper.getStudent(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public int deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student, long id) {
        return studentMapper.updateStudent(student, id);
    }


    public List<Student> getStudentByName(String name) {
        return studentMapper.getStudentByName(name);
    }
}
