package com.vn.devmaster.services.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.vn.devmaster.services.domain.Subject}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDto{
    private Integer id;
    private String name;
}