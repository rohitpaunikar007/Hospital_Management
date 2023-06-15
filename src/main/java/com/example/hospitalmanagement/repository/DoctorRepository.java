package com.example.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	    // You can add custom query methods if needed
}
