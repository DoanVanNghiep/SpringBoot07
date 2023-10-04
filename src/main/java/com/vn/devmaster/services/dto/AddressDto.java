package com.vn.devmaster.services.dto;

import lombok.*;



/**
 * DTO for {@link com.vn.devmaster.services.domain.Address}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@Value
public class AddressDto{
    Integer id;
    String name;
    String city;
    String district;
}