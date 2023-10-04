package com.vn.devmaster.services.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.vn.devmaster.services.domain.Class}
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Value
public class ClassDto{
    Integer id;
    String name;
}