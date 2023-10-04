package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.domain.Class;
import com.vn.devmaster.services.dto.ClassDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClassMapper implements  EntityMapper<Class, ClassDto>{
    @Override
    public Class toEntity(ClassDto classDto) {
        return Class.builder()
                .id(classDto.getId())
                .name(classDto.getName())
                .build();
    }

    @Override
    public List<Class> toEntity(List<ClassDto> d) {
        List<Class> classes = new ArrayList<>();
        d.forEach( classDto -> {
            classes.add(toEntity(classDto));
        });
        return classes;
    }

    @Override
    public ClassDto toDO(Class aClass) {
        return ClassDto.builder()
                .id(aClass.getId())
                .name(aClass.getName())
                .build();
    }

    @Override
    public List<ClassDto> toDO(List<Class> e) {
        List<ClassDto> dtos = new ArrayList<>();
        e.forEach(aClass -> {
            dtos.add(toDO(aClass));
        });
        return dtos;
    }
}
