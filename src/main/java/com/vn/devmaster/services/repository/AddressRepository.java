package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.domain.Address;
import com.vn.devmaster.services.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address , Integer> {
}
