package com.manager.controller;

import com.manager.domain.Course;
import com.manager.domain.SC;
import com.manager.domain.Student;
import com.manager.service.StudentDetailService;
import com.manager.service.StudentService;
import com.manager.vo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生选课信息Controller
 */
@Controller
@RequestMapping("/detail")
public class StudentDetailController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentDetailService studentDetailService;

    /**
     * 按学号查询指定学生的课程情况
     * @param id 要查询的学生的学号
     */
    @RequestMapping("/list")
    public String studentDetail(@RequestParam("id") long id, Model model) {
        List<StudentGrade> list = studentDetailService.getStudentDetail(id);
        Student student = studentService.getStudent(id);
        model.addAttribute("list", list);
        model.addAttribute("student", student);
        return "studentDetail";
    }

    /**
     * 根据学号和课程号删除学生选课信息
     * @param cno 课程号
     * @param sno 学号
     */
    @RequestMapping("/delete")
    public String deleteDetail(long cno, long sno) {
        studentDetailService.deleteDetail(cno, sno);
        return "redirect:/detail/list?id=" + sno;
    }

    /**
     * 根据学号和课程号取得学生选课信息，并放入model中，再转发到编辑表单页面回显
     */
    @RequestMapping("/edit")
    public String edit(long cno, long sno, Model model) {
        StudentGrade studentGrade = studentDetailService.getDetail(cno, sno);
        model.addAttribute("studentGrade", studentGrade);
        return "editDetailForm";
    }

    /**
     * 更新学生选课信息
     */
    @RequestMapping("/editDetail")
    public String editDetail(@RequestParam("cno") long cno, @RequestParam("sno") long sno,
                             @RequestParam("grade") float grade) {
        studentDetailService.updateDetail(cno, sno, grade);
        return "redirect:/detail/list?id=" + sno;
    }

    /**
     * 先取得所有课程信息，再将课程信息和学生学号放入model，转发到新增信息表单页面
     */
    @RequestMapping("/insert")
    public String insert(@RequestParam("id") long id, Model model) {
        List<Course> courseList = studentDetailService.getCourseList();
        model.addAttribute("courselist", courseList);
        model.addAttribute("sno", id);
        return "insertDetailForm";
    }

    /**
     * 将新增表单页面上数据封装成SC对象，若校验后发现有错误，则将错误转发到新增表单；否则进行更新
     */
    @RequestMapping("/insertDetail")
    public String insertDetail(@Valid SC sc, Errors errors, Model model) {
        // 若有错误，则取得错误信息，添加到list中，返回前台
        if(errors.hasErrors()) {
            List<FieldError> errorlist = errors.getFieldErrors();
            List<String> errormsg = new ArrayList<>();
            for (FieldError error : errorlist) {
                String item = error.getField();
                errormsg.add(item + " ： 输入格式有误");
                System.out.println("error:" + item);
            }
            model.addAttribute("errormsg", errormsg);
            return "forward:insert?id=" + sc.getSno();
        }
        studentDetailService.insertDetail(sc);
        return "redirect:/detail/list?id=" + sc.getSno();
    }
}
