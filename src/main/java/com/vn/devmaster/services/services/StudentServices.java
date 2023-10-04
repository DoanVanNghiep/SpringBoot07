package com.vn.devmaster.services.services;

import com.vn.devmaster.services.domain.Address;
import com.vn.devmaster.services.domain.Class;
import com.vn.devmaster.services.domain.Student;
import com.vn.devmaster.services.domain.Subject;
import com.vn.devmaster.services.dto.AddressDto;
import com.vn.devmaster.services.dto.ClassDto;
import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.dto.SubjectDto;
import com.vn.devmaster.services.mapper.AddressMapper;
import com.vn.devmaster.services.mapper.ClassMapper;
import com.vn.devmaster.services.mapper.StudentMapper;
import com.vn.devmaster.services.mapper.SubjectMapper;
import com.vn.devmaster.services.projection.IStudentFIlterclass;
import com.vn.devmaster.services.repository.AddressRepository;
import com.vn.devmaster.services.repository.ClassRepository;
import com.vn.devmaster.services.repository.StudentRepository;
import com.vn.devmaster.services.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassMapper classMapper;
    public List<StudentDTO> getAll(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDO(students);
    }

    //get all subject
    public List<SubjectDto> getAllSubject(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjectMapper.toDO(subjects);
    }
    public void save(StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }
    public List<StudentDTO> sreachName(String name){
        List<Student> students = studentRepository.getByName(name);
        return studentMapper.toDO(students);
    }

    public void save(List<StudentDTO> studentDTOS) {
        List<Student> students = studentMapper.toEntity(studentDTOS);
//        students.forEach(student -> studentRepository.save(student));
        studentRepository.saveAll(students);
    }
    // Địa chỉ
    public List<AddressDto> getAllAddress(){
        List<Address> addresses = addressRepository.findAll();
        return addressMapper.toDO(addresses);
    }
    public List<AddressDto> sreachByID(Integer ID){
        Address list = studentRepository.getById(ID).getAddress();
        return Collections.singletonList(addressMapper.toDO(list));
    }
    public List<StudentDTO> sreachDiaChi(String city) {
        List<Student> students = studentRepository.findAllByAddress_City(city);
        return studentMapper.toDO(students);
    }
    public List<StudentDTO> sreachSubject(String subject){
        List<Student> students = studentRepository.findAllBySubjects(subject);
        return studentMapper.toDO(students);
    }
    public List<StudentDTO> sreachPoint(){
        List<Student> students = studentRepository.findAllByPoint();
        return studentMapper.toDO(students);
    }

    // GET ALL Classes
    public List<ClassDto> getAllClass(){
        List<Class> classes = classRepository.findAll();
        return  classMapper.toDO(classes);
    }

    // tìm kiếm sinh viên ở lớp DEV01
    public List<StudentDTO> sreachClass(){
        List<Student> students = studentRepository.findAllByClass();
        return studentMapper.toDO(students);
    }

}
