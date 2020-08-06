package com.cybertek.mvcthymeleaf.controller;

import com.cybertek.mvcthymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cybertek/thymeleaf")
public class ThymeleafController {

    private List<Student> students;

    public ThymeleafController() {
        listAllStudent();
    }

    @GetMapping("/box")
    public String boxExample(Model model) {
        model.addAttribute("students", students);
        return "thymeleaf/box";
    }

    @GetMapping("/form")
    public String formExample() {
        return "thymeleaf/form";
    }

    @GetMapping("/table")
    public String tableExample(Model model) {
        model.addAttribute("students", students);
        return "thymeleaf/table";
    }

    @GetMapping("/details/{id}")
    public String detailsExample(@PathVariable Integer id) {
        return "thymeleaf/details";
    }

    @PostMapping("/create-student")
    public String addStudentExample(@ModelAttribute("student") Student student) {
        return "redirect:details/" + "1";
    }

    private List<Student> listAllStudent() {
        students = new ArrayList<>();
        students.add(new Student(1, "John Doe", 25, "23rd St @ 5th Ave", "/images/logo.png"));
        students.add(new Student(2, "Arron Bender", 32, "Mint Bridge Road", "/images/logo.png"));
        students.add(new Student(3, "Catrina Naylor", 27, "Houghwood Grange", "/images/logo.png"));
        students.add(new Student(4, "Una Lugo", 29, "Swallow Mews", "/images/logo.png"));
        students.add(new Student(5, "Rosanna Vance", 37, "Oak Park Lane", "/images/logo.png"));
        return students;
    }
}
