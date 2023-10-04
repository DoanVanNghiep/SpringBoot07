package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.domain.Address;
import com.vn.devmaster.services.dto.AddressDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AddressMapper implements EntityMapper<Address, AddressDto> {

    @Override
    public Address toEntity(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
//                .name(addressDto.getName())
                .city(addressDto.getCity())
                .district(addressDto.getDistrict())
                .build();
    }

    @Override
    public List<Address> toEntity(List<AddressDto> d) {
        List<Address> list = new ArrayList<>();
        d.forEach(addressDto -> {
            list.add(toEntity(addressDto));
        });
        return list;
    }

    @Override
    public AddressDto toDO(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .district(address.getDistrict())
//                .name(address.getName())
                .build();
    }

    @Override
    public List<AddressDto> toDO(List<Address> e) {
        List<AddressDto> dtos = new ArrayList<>();
        e.forEach( address -> {
            dtos.add(toDO(address));
        });
        return dtos;
    }
}
