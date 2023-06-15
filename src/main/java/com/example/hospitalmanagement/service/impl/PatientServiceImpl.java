package com.example.hospitalmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.exceptions.ResourceNotFoundException;
import com.example.hospitalmanagement.payloads.PatientDto;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PatientDto createPatient(PatientDto patientDto) {
		Patient patient=this.dtoToPatient(patientDto);
		Patient savedPatient=this.patientRepository.save(patient);
		return this.patientToDto(savedPatient);
	}
	
	@Override
	public PatientDto updatePatient(PatientDto patientDto, Long patientId) {
			
			Patient patient=this.patientRepository.findById(patientId)
			 .orElseThrow(()-> new ResourceNotFoundException("Patient","id",patientId));
							
			patient.setFirstName(patientDto.getFirstName());
			patient.setLastName(patientDto.getLastName());
			patient.setGender(patientDto.getGender());
			patient.setDateOfBirth(patientDto.getDateOfBirth());
				
				Patient updatedPatient=this.patientRepository.save(patient);
				return patientToDto(updatedPatient);

	}

	@Override
	public PatientDto getPatientById(Long patientId) {
			
	Patient patient = patientRepository.findById(patientId)
	.orElseThrow(() -> new ResourceNotFoundException("Patient", " Id ", patientId));	
		return patientToDto(patient);
	}

	@Override
	public List<PatientDto> getAllPatients() {
	 List<Patient> patients = patientRepository.findAll();
		    return patients.stream()
		        .map(this::patientToDto).collect(Collectors.toList());
	}

	@Override
	public void deletePatient(Long patientId) {
		Patient patient = this.patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
						this.patientRepository.delete(patient);

	}
	public Patient dtoToPatient(PatientDto patientDto) {
		Patient patient = this.modelMapper.map(patientDto, Patient.class);

	//	patient.setId(patientDto.getId());
	//	patient.setFirstName(patientDto.getFirstName());
	//	patient.setLastName(patientDto.getLastName());
	//	patient.setDateOfBirth(patientDto.getDateOfBirth());	
		return patient;
	}
	
	public PatientDto patientToDto(Patient patient) {
		PatientDto patientDto = this.modelMapper.map(patient, PatientDto.class);

	//	patientDto.setId(patient.getId());
	//	patientDto.setFirstName(patient.getFirstName());
	//	patientDto.setLastName(patient.getLastName());
	//	patientDto.setDateOfBirth(patient.getDateOfBirth());
		return patientDto;
	}

}
