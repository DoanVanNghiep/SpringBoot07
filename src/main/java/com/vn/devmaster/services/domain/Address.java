package com.vn.devmaster.services.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "address", schema = "manage-student")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "name", length = 250)
//    private String name;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "district", length = 50)
    private String district;

    @OneToMany
    @JoinColumn(name = "id_address")
    List<Student> students = new ArrayList<>();
    // manytoone sẽ cũng giống như thế tuy nhiên ở đây ko sử dụng một danh sách nữa mà sử dụng như onetoone


}