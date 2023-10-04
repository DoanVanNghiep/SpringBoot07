package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.domain.Subject;
import com.vn.devmaster.services.dto.SubjectDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper implements EntityMapper<Subject, SubjectDto> {

    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        return Subject
                .builder()
                .id(subjectDto.getId())
                .name(subjectDto.getName())
                .build();
    }

    @Override
    public List<Subject> toEntity(List<SubjectDto> d) {
        List<Subject> subjects = new ArrayList<>();
        d.forEach(subjectDto -> {
            subjects.add(toEntity(subjectDto));
        });
        return subjects;
    }

    @Override
    public SubjectDto toDO(Subject subject) {
        SubjectDto dto = SubjectDto.builder()
                .name(subject.getName())
                .id(subject.getId())
                .build();
        return dto;
    }

    @Override
    public List<SubjectDto> toDO(List<Subject> e) {
        List<SubjectDto> dtos = new ArrayList<>();
        e.forEach(subject ->{
            dtos.add(toDO(subject));
        });
        return dtos;
    }
}
