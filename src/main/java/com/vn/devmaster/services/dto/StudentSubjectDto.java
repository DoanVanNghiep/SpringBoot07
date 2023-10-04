package com.vn.devmaster.services.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.vn.devmaster.services.domain.StudentSubject}
 */
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class StudentSubjectDto{
    Integer point;
}