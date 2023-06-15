package com.example.hospitalmanagement.service;

import java.util.List;

import com.example.hospitalmanagement.payloads.PatientDto;

public interface PatientService {
	
   PatientDto createPatient(PatientDto patient);
   
   PatientDto updatePatient(PatientDto patientDto, Long patientId);
   
   PatientDto getPatientById(Long patientId);
   
   List<PatientDto> getAllPatients();
    
    void deletePatient(Long patientId);
}
