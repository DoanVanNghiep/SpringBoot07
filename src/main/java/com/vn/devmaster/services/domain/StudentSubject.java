package com.vn.devmaster.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student_subject")
@Entity
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_student", nullable = false)
    private Integer id_student;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_subject", nullable = false)
    private Integer id_subject;

    @Column(name = "point")
    private Integer point;

}
