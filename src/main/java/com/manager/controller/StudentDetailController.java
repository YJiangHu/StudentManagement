package com.manager.controller;

import com.manager.domain.SC;
import com.manager.domain.Student;
import com.manager.service.StudentDetailService;
import com.manager.service.StudentService;
import com.manager.vo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping("/delete")
    public String deleteDetail(long cno, long sno) {
        studentDetailService.deleteDetail(cno, sno);
        return "redirect:/detail/list?id=" + sno;
    }

    @RequestMapping("/edit")
    public String edit(long cno, long sno, Model model) {
        StudentGrade studentGrade = studentDetailService.getDetail(cno, sno);
        model.addAttribute("studentGrade", studentGrade);
        return "editDetailForm";
    }

    @RequestMapping("/editDetail")
    public String editDetail(@RequestParam("cno") long cno, @RequestParam("sno") long sno,
                             @RequestParam("grade") float grade) {
        studentDetailService.updateDetail(cno, sno, grade);
        return "redirect:/detail/list?id=" + sno;
    }

    @RequestMapping("/insert")
    public String insert() {
        return "insertDetailForm";
    }

    @RequestMapping("/insertDetail")
    public String insertDetail(SC sc) {
        studentDetailService.insertDetail(sc);
        return "redirect:/detail/list";
    }
}
