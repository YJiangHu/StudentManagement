package com.manager.service;

import com.manager.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(long id);
    List<Student> getAllStudent();
    int deleteStudent(long id);
    int insertStudent(Student student);
    int updateStudent(Student student, long id);
    List<Student> getStudentByName(String name);
}
