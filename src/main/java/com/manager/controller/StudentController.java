package com.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.domain.Student;
import com.manager.service.StudentDetailService;
import com.manager.service.StudentService;
import com.manager.vo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/studentmanager")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentDetailService studentDetailService;

    /**
     * 显示学生信息列表
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "pn", defaultValue = "1", required = false) int pn) {
        PageHelper.startPage(pn, 5);
        List<Student> list = studentService.getAllStudent();
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentList");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    /**
     * 按学号查找学生
     * @param id 要查询的学生的学号
     */
    @RequestMapping("/getStudent")
    public String findStudent(@RequestParam("id") long id, Model model) {
        return "redirect:/studentmanager/detail?id=" + id;
    }

    /**
     * 按学号查询指定学生的课程情况
     * @param id 要查询的学生的学号
     */
    @RequestMapping("/detail")
    public String studentDetail(@RequestParam("id") long id, Model model) {
        List<StudentGrade> list = studentDetailService.getStudentDetail(id);
        Student student = studentService.getStudent(id);
        model.addAttribute("list", list);
        model.addAttribute("student", student);
        return "studentDetail";
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("id") long id) {
        studentService.deleteStudent(id);
        return "redirect:/studentmanager/list";
    }

    @RequestMapping("/insertForm")
    public String insertForm(Model model) {
        return "insertForm";
    }

    @RequestMapping("/insertStudent")
    public String insertStudent(Student student) {
        if(studentService.getStudent(student.getId()) != null) {
            return "failed";
        } else {
            studentService.insertStudent(student);
            return "redirect:/studentmanager/list";
        }
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "editForm";
    }

    @RequestMapping("/editStudent")
    public String editStudent(Student student, @RequestParam("id") long id) {
        studentService.updateStudent(student, id);
        System.out.println("表单： " + student);
        return "redirect:/studentmanager/list";
    }

    @RequestMapping("/query")
    public String getStudentByName(@RequestParam(value = "pn", defaultValue = "1", required = false) int pn,
                                   String name, Model model) {
        PageHelper.startPage(pn, 5);
        List<Student> list = studentService.getStudentByName(name);
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo", pageInfo);
        return "queryResult";
    }
}
