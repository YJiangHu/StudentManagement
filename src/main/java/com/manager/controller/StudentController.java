package com.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.domain.Student;
import com.manager.service.StudentDetailService;
import com.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 学生个人信息Controller
 */
@Controller
@RequestMapping("/studentmanager")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentDetailService studentDetailService;

//    /**
//     * 第一种在每个方法执行前，若参数中存在id（学号），则从数据库中取得学生信息，放进map
//     * @param id 学号（不是必须的）
//     * @param map 存放取得的学生对象
//     */
//    @ModelAttribute
//    public void model(@RequestParam(name = "id", required = false) Long id,
//                      Map<String, Student> map) {
//        if(id != null) {
//            Student student = studentService.getStudent(id);
//            map.put("student", student);
//        }
//    }

    /**
     * 显示学生信息列表
     * @Param page 页码（不是必须的），若没有给定页码，则默认为0
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",
            defaultValue = "1", required = false) int page) {
        // 每页5条记录，当前页码为page
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
    public String findStudent(@RequestParam(name = "id", required = false) String id,
                              Model model) {
//        // 若输入了学号，则查找学生信息，转到/detail/list
//        if(id != null) {
//            id = id.replace(" ", "");
//            long sno = Long.valueOf(id);
//            return "redirect:/detail/list?id=" + sno;
//        }
//        // 若没有输入学号，则返回列表页，即等价于查找所有学生
//        return "redirect:/studentmanager/list";
        // 替换掉浏览器传来的参数中的空格和加号（拼接符）
        id = id.replaceAll(" ", "").replaceAll("//+", "");
        long sno;
        try {
            // 尝试将参数转换成long类型
            sno = Long.parseLong(id);
        } catch (NumberFormatException e) {
            // 若转换失败，证明输入的不是有效的数字，则添加错误信息内容，并重定向到学生信息列表
            model.addAttribute("msg", "学号输入格式有误！");
            return "forward:list";
        }
        // 转换成功，重定向到具体查询结果页面
        return "redirect:/detail/list?id=" + sno;
    }

    /**
     * 先查询所有班级的信息，然后转发到高级查询表单页面
     */
    @RequestMapping("/query")
    public String query(Model model) {
        Set<String> clazzSet = studentService.getAllClazz();
        model.addAttribute("clazzSet", clazzSet);
        return "advanceQuery";
    }
    /**
     * 通过页面输入的学号，姓名以及班级的不同组合查询学生信息
     * @param id 学号，可以不输入
     * @param name 姓名，可以不输入
     * @param clazz 班级，可以不输入
     */
    @RequestMapping("/queryStudent")
    public String query(@RequestParam(name = "id", required = false) String id,
                        @RequestParam(name = "name", required = false) String name,
                        @RequestParam(name = "clazz", required = false) String clazz, Model model) {
        id = id.replaceAll(" ", "").replaceAll("//+", "");
        Long sno = 0L;
        if(id != "") {
            try {
                sno = Long.parseLong(id);
            } catch (NumberFormatException e) {
                model.addAttribute("msg", "学号输入有误！");
                return "forward:query";
            }
        }
        name = name.replaceAll(" ", "").replaceAll("//+", "");
        clazz = clazz.replaceAll(" ", "").replaceAll("//+", "");
        List<Student> list = studentService.getStudentByMulti(sno, name, clazz);
        model.addAttribute("list", list);
        return "queryResult";
    }

    /**
     * 按学号删除学生
     * @param id 要查询的学生的学号
     */
    @RequestMapping("/delete")
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
    public String insertStudent(@Valid Student student, Errors errors, Model model) {
        // 若有错误，则取得错误信息，添加到list中，返回前台
        if(errors.hasErrors()) {
            List<FieldError> errorlist = errors.getFieldErrors();
            List<String> errormsg = new ArrayList<>();
            for(FieldError error : errorlist) {
                String item = error.getField();
                errormsg.add(item + " ： 输入格式有误");
                System.out.println("error:" + item);
            }
            model.addAttribute("errormsg", errormsg);
            return "forward:insertForm";
        } else {
            // 如果数据库中有相同的学号的学生信息，则跳转到错误页面
            if (studentService.getStudent(student.getId()) != null) {
                model.addAttribute("msg", "学号冲突！");
                return "forward:insertForm";
            } else {
                // 否则进行插入，然后返回学生信息列表
                studentService.insertStudent(student);
                return "redirect:/studentmanager/list";
            }
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
     */
    @RequestMapping("/editStudent")
    public String editStudent(@Valid Student student, Errors errors,
            @RequestParam("id") long id, Model model) {
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
            return "forward:edit";
        }
        studentService.updateStudent(student, id);
        return "redirect:/studentmanager/list";
    }

//    @ExceptionHandler(StudentException.class)
//    public String handleStudentException(StudentException e) {
//        return "failed";
//    }
}
