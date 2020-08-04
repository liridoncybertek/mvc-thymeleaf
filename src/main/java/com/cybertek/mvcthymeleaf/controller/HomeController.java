package com.cybertek.mvcthymeleaf.controller;

import com.cybertek.mvcthymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/cybertek")
public class HomeController {

    @RequestMapping("/home")
    public String requestMappingEx() {
        return "home";
    }

    /**
     * Method parameter accept all http methods including (GET, POST, PUT, DELETE)
     *
     * @return home view
     */
    @RequestMapping(method = RequestMethod.GET, value = "/home-2")
    public String requestMappingWithMethodEx() {
        return "home";
    }

    /**
     * This method is shortcut for {@link #requestMappingWithMethodEx()}} method.
     * In the same way, we can use @PostMapping, @PutMapping and @DeleteMapping.
     * Usually method are declared on this way, is best practice.
     *
     * @return home view.
     */
    @GetMapping(value = "/home-3")
    public String getMappingEx() {
        return "home";
    }

    /**
     * Send parameter in url, with {@link PathVariable} annotation.
     * Ex: /home-4/cybertek --- cybertek is parameter we need.
     *
     * @param name parameter to read from url {@link String}
     * @return home view
     */
    @GetMapping(value = "/home-4/{name}")
    public String pathVariableEx(@PathVariable("name") String name) {
        System.out.println("name is: " + name);
        return "home";
    }

    /**
     * Send query parameter in url, with {@link RequestParam} annotation
     * Ex: /home-5?name=cybertek -- cybertek will be the value of name.
     *
     * @param name parameter to read from url as queryParam {@link String}
     * @return home-view
     */
    @GetMapping(value = "/home-5")
    public String requestParamEx(@RequestParam("name") String name) {
        System.out.println("name is: " + name);
        return "home";
    }

    /**
     * Send optional query parameter in url, with {@link RequestParam} annotation
     * Ex: /home-5?name=cybertek -- cybertek will be the value of name.
     * If query  parameter is not present, default value will present as value, "CyberTekSchool" in our case.
     *
     * @param name parameter to read from url as queryParam {@link String}
     * @return home-view
     */
    @GetMapping(value = "/home-6")
    public String requestParamEx2(@RequestParam(value = "name", required = false, defaultValue = "CyberTekSchool") String name) {
        System.out.println("name is: " + name);
        return "home";
    }

    /**
     * Add student view
     * @return
     */
    @GetMapping(value = "/add-student")
    public String addAStudent() {
        return "add-student";
    }


    /**
     * Create student.
     * How post mapping work.
     * @param student
     * @return
     */
    @PostMapping(value = "/create-student")
    public String postRequestEx(@ModelAttribute("student") Student student) {
        System.out.println("student data are: " +  student);
        System.out.println("student name is: " +  student.getName());
        System.out.println("student age is: " +  student.getAge());
        return "show-student";
    }
}
