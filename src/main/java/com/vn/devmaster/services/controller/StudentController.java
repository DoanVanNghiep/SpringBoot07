package com.vn.devmaster.services.controller;
import com.vn.devmaster.services.dto.AddressDto;
import com.vn.devmaster.services.dto.ClassDto;
import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.dto.SubjectDto;
import com.vn.devmaster.services.projection.*;
import com.vn.devmaster.services.repository.StudentRepository;
import com.vn.devmaster.services.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    List<StudentDTO> getAll(){
        return studentServices.getAll();
    }

    //get all address
    @GetMapping("/address")
    List<AddressDto> getAllAD(){
        return studentServices.getAllAddress();
    }

    // tìm kiếm theo ID address
    @GetMapping("/addressID")
    List<AddressDto> getByID(@RequestParam("ID") Integer ID){
        List<AddressDto> dtos = studentServices.sreachByID(ID);
        return dtos;
    }

    // tìm kiếm những học sinh có địa chỉ ở hà nội
    @GetMapping("/addressDC")
    List<StudentDTO> getByDC(@RequestParam("diachi") String dc){
        List<StudentDTO> list = studentServices.sreachDiaChi(dc);
        return list;
    }


    // tìm kiếm theo tên sinh viên
    @GetMapping("/filter-name")
    List<StudentDTO> sreachByName(@RequestParam("name") String name){
        List<StudentDTO> dtos = studentServices.sreachName(name);
        return dtos;
    }

    // get all subject
    @GetMapping("/filter-subject")
    List<SubjectDto> getAllSubjet(){
       return studentServices.getAllSubject();
    }
    // tìm kiếm môn học
    @GetMapping("/subject")
    List<StudentDTO> sreachBySubject(@RequestParam("subject") String subject){
        List<StudentDTO> dtos = studentServices.sreachSubject(subject);
        return dtos;
    }

    // tìm kiếm có điểm lớn hơn 8
    @GetMapping("/subLonHon8")
    List<StudentDTO> sreachByPoint(){
        List<StudentDTO> studentDTOS = studentServices.sreachPoint();
        return studentDTOS;
    }

    // get all class
    @GetMapping("/class")
    List<ClassDto> getAllClass(){
        return studentServices.getAllClass();
    }

    //tìm kiếm sinh viên học ở lớp DEV01
    @GetMapping("/ClassDEV01")
    List<StudentDTO> sreachByClass(){
        List<StudentDTO> studentDTOS = studentServices.sreachClass();
        return studentDTOS;
    }

    // tìm kiếm sinh viên học ở lớp DEV02
    @GetMapping("/classDEV02")
    List<IStudentFIlterclass> sreachClassDEV02(@RequestParam("name") String className){
        return studentRepository.findAllByAClass_Name(className);
    }

    @GetMapping("/filter-by-AVG")
    List<IStudentFilerAVG> sreachAVG(@RequestParam("Name") String className){
        return studentRepository.findAllByClass_AVG(className);
    }

    //diem trung binh lon hon 8
    @GetMapping("/Filet_by_AVG")
    List<IStudentFilterAVG8> avg8s(@RequestParam("Name") String className){
        return studentRepository.findAllByClass_AVG8(className);
    }

    // tim sinh vien A
    @GetMapping("/Point_by_avg")
    List<IStudentPointAVG> avg(@RequestParam("name") String nameSubject){
        return studentRepository.findStudentBy_AVG(nameSubject);
    }

    // điểm cao nhất của sinh viên tìm kiếm
    @GetMapping("/MaxPoint")
    List<IStudentFilerMaxPoint> maxPoints(@RequestParam("studentName") String studentName){
        return studentRepository.findStudentBy_PointMax(studentName);
    }

    // học bổng cao nhất của sinh viên
    @GetMapping("/MaxHocBong")
    List<IStudentFilerMaxHocBong> maxHocBongs(){
        return studentRepository.findStudentBy_HocBongMax();
    }
    @PostMapping("/student")
    String save(@RequestBody StudentDTO studentDTO){
        studentServices.save(studentDTO);
        return "Thành công!";
    }

    //thêm nhiều sinh viên
    @PostMapping("/addstudents")
    String save(@RequestBody List<StudentDTO> studentDTOS){
        studentServices.save(studentDTOS);
        return "OK";
    }
}
