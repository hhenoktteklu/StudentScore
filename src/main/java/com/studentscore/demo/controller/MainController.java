package com.studentscore.demo.controller;

import com.studentscore.demo.entity.Student;
import com.studentscore.demo.entity.Test;
import com.studentscore.demo.repository.StudentRepository;
import com.studentscore.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TestRepository testRepository;

    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @RequestMapping("/createstudent")
    public String createStudent(Model model){
        model.addAttribute("student" ,new Student());
        return "createstudent";
    }

    @PostMapping("/processstudent")
    public String processStudent(Model model, Student student){
        model.addAttribute("student", student);
        studentRepository.save(student);
        return "confirmationstudent";
    }
    @RequestMapping("/createtest")
    public String createTest(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("test", new Test());
        return "createtest";
    }

    @RequestMapping("/processtest")
    public String processTest(Model model, Test test){
        testRepository.save(test);
        return "confirmationtest";
    }
}
