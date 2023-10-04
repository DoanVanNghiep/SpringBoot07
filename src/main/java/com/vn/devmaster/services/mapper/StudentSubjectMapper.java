package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.domain.StudentSubject;
import com.vn.devmaster.services.dto.StudentSubjectDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentSubjectMapper implements EntityMapper<StudentSubject, StudentSubjectDto>{
    @Override
    public StudentSubject toEntity(StudentSubjectDto studentSubjectDto) {
        return StudentSubject.builder()
                .point(studentSubjectDto.getPoint())
                .build();
    }

    @Override
    public List<StudentSubject> toEntity(List<StudentSubjectDto> d) {
        List<StudentSubject> subjects = new ArrayList<>();
        d.forEach(studentSubjectDto ->{
            subjects.add(toEntity(studentSubjectDto));
        });
        return subjects;
    }

    @Override
    public StudentSubjectDto toDO(StudentSubject studentSubject) {
        return StudentSubjectDto.builder()
                .point(studentSubject.getPoint())
                .build();
    }

    @Override
    public List<StudentSubjectDto> toDO(List<StudentSubject> e) {
        List<StudentSubjectDto> studentSubjectDtos = new ArrayList<>();
        e.forEach(studentSubject -> {
            studentSubjectDtos.add(toDO(studentSubject));
        });
        return studentSubjectDtos;
    }
}
