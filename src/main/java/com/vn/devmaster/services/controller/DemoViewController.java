package com.vn.devmaster.services.controller;

import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class DemoViewController {
    @Autowired
    private StudentServices studentServices;

//    @GetMapping("/demo/{name}")
//    public String viewDemo(@PathVariable("name") String name, Model model){
//        model.addAttribute("name",  name);
//        return "demo";
//    }
//
//    @GetMapping("/demo/student")
//    public  String showDemo(Model model){
//        StudentDTO dto = new StudentDTO();
//        dto.setFirstName("Đoàn");
//        dto.setLastName("Nghiệp");
//        model.addAttribute("student",dto);
//        // return ra hmtl vừa khởi tạo
//        return "demo";
//    }

    @GetMapping("/demo/students")
    public String showDemo(Model model){
        model.addAttribute("student",studentServices.getAll());
        return "demo";
    }
    @GetMapping("/subject/subjects")
    public String showSubject(Model model){
        model.addAttribute("subject", studentServices.getAllSubject());
        return "subject";
    }
    @GetMapping("/address/addresses")
    public String showAddress(Model model){
        model.addAttribute("address", studentServices.getAllAddress());
        return "address";
    }
}
