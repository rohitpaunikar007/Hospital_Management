package com.example.hospitalmanagement.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagement.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	    // You can add custom query methods if needed
	}

