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
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
        PageHelper.startPage(page, 5);
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
    public String findStudent(@RequestParam(name = "id", required = false) Long id,
                              Model model) {
        if(id != null) {
            return "redirect:/detail/list?id=" + id;
        }
        return "redirect:/studentmanager/list";
    }

    /**
     * 按学号删除学生
     * @param id 要查询的学生的学号
     */
    @RequestMapping(name = "/student", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam("id") long id) {
        studentService.deleteStudent(id);
        return "redirect:/studentmanager/list";
    }

    /**
     * 进入插入学生信息表单
     */
    @RequestMapping("/insertForm")
    public String insertForm() {
        return "insertForm";
    }

    /**
     * 将表单中的Student对象插入数据库
     * @param student 将表单上的信息封装成Student对象
     */
    @RequestMapping("/insertStudent")
    public String insertStudent(Student student) {
        // 如果数据库中有相同的学号，则回滚报错
        if(studentService.getStudent(student.getId()) != null) {
            return "failed";
        } else {
            // 否则进行插入，然后返回学生信息列表
            studentService.insertStudent(student);
            return "redirect:/studentmanager/list";
        }
    }

    /**
     * 获取要修改的学生的学生信息，进入编辑表单，并对其基本信息进行回显
     * @param id 要修改信息的学生的学号
     */
    @RequestMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "editForm";
    }

    /**
     * 对指定学号的学生信息进行修改
     * @param student 将表单上的信息封装成Student对象
     * @param id 要修改信息的学生的学号
     */
    @RequestMapping("/editStudent")
    public String editStudent(Student student, @RequestParam("id") long id) {
        studentService.updateStudent(student, id);
        System.out.println("表单： " + student);
        return "redirect:/studentmanager/list";
    }

//    @RequestMapping("/query")
//    public String getStudentByName(@RequestParam(value = "pn", defaultValue = "1", required = false) int pn,
//                                   String name, Model model) {
//        PageHelper.startPage(pn, 5);
//        List<Student> list = studentService.getStudentByName(name);
//        PageInfo pageInfo = new PageInfo(list);
//        model.addAttribute("pageInfo", pageInfo);
//        return "queryResult";
//    }
}
