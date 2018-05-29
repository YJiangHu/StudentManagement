package com.manager.dao;

import com.manager.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    // 1. 根据 id 获取学生信息
    Student getStudent(long id);
    // 2. 获取所有学生
    List<Student> getAllStudent();
    // 3. 根据 id 删除学生
    int deleteStudent(long id);
    // 4. 添加学生
    int insertStudent(Student student);
    // 5. 修改学生信息
    int updateStudent(@Param("student") Student student, @Param("id") long id);
    // 6. 按名字查询
    List<Student> getStudentByName(String name);
}