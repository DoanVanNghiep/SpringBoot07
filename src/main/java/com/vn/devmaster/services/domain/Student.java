package com.vn.devmaster.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    Address address;

    @OneToOne
    @JoinColumn(name = "id_class")
    Class aClass;

    @OneToOne
    @JoinColumn(name = "id_student")
    @JoinColumn(name = "id_subject")
    StudentSubject subject;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn( name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    List<Subject> subjects = new ArrayList<>();
}
