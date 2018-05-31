package com.manager.controller;

import com.manager.domain.Student;
import com.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public void model(@RequestParam(name = "id", required = false) Long id,
                      Map<String, Student> map) {
        System.out.print("Model: ");
        if(id != null) {
            Student student = new Student();
            student.setId(id);
            student.setName("hyj");
            student.setSex('男');
            student.setClazz("1501");
            student.setPhone(156165);
            map.put("abc", student);
            System.out.println(student);
        }
    }
    @RequestMapping("/form")
    public String loginForm() {
        return "test";
    }

    @RequestMapping("/login")
    public void login(@ModelAttribute("abc") Student student, Model model) {
        System.out.println("表单提交： " + student);
    }
}
