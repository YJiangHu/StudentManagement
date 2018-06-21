package com.manager.dao;

import com.manager.domain.Course;
import com.manager.domain.SC;
import com.manager.vo.StudentGrade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDetailMapper {
    // 1. 根据 id 获取学生选课信息及课程信息
    List<StudentGrade> getStudentDetail(long id);
    // 2. 根据学生 id 和 课程 id 获取选课信息
    StudentGrade getDetail(@Param("cno") long cno, @Param("sno") long sno);
    // 3. 根据学生 id 和 课程 id 删除选课信息
    int deleteDetail(@Param("cno") long cno, @Param("sno") long sno);
    // 4. 修改选课信息
    int updateDetail(@Param("cno") long cno, @Param("sno") long sno, @Param("grade") float grade);
    // 5. 增加选课信息
    int insertDetail(SC sc);
    // 6. 获取所有课程信息
    List<Course> getCourseList();
    // 7. 获取指定学号学生没有选的课程
    List<Course> getCourseListNotSelect(@Param("sno") long sno);
}