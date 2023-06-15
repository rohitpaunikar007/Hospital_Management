package com.example.hospitalmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.exceptions.*;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.payloads.DoctorDto;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
	       this.doctorRepository = doctorRepository;
	 }
	
	@Override
	public DoctorDto createDoctor(DoctorDto doctorDto) {
	Doctor doctor=this.dtoToDoctor(doctorDto);
	Doctor savedDoctor=this.doctorRepository.save(doctor);
		return this.doctorToDto(savedDoctor);
	}

	@Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
		
	Doctor doctor=this.doctorRepository.findById(doctorId)
	 .orElseThrow(()-> new ResourceNotFoundException("Doctor","id",doctorId));
					
		doctor.setFirstName(doctorDto.getFirstName());
		doctor.setLastName(doctorDto.getLastName());
		doctor.setSpecialization(doctorDto.getSpecialization());
		
		Doctor updatedDoctor=this.doctorRepository.save(doctor);
		DoctorDto doctorDto1=this.doctorToDto(updatedDoctor);
		return doctorDto1;		    	
	}

	@Override
	public DoctorDto getDoctorById(Long doctorId) {
		
		Doctor doctor = doctorRepository.findById(doctorId)
		.orElseThrow(() -> new ResourceNotFoundException("Doctor","Id", doctorId));
		 
	return doctorToDto(doctor);
	}

	@Override
	public List<DoctorDto> getAllDoctors() {
		 List<Doctor> doctors = doctorRepository.findAll();
	 return doctors.stream().map(this::doctorToDto).collect(Collectors.toList());
	}

	@Override
	public void deleteDoctor(Long doctorId) {
		
	Doctor doctor = this.doctorRepository.findById(doctorId)
	.orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
		this.doctorRepository.delete(doctor);
	}
		
		
	public DoctorDto doctorToDto(Doctor doctor) {
		DoctorDto doctorDto= this.modelMapper.map(doctor,DoctorDto.class);

	//	doctorDto.setId(doctor.getId());
	//	doctorDto.setFirstName(doctor.getFirstName());
	//	doctorDto.setLastName(doctor.getLastName());
	//	doctorDto.setSpecialization(doctor.getSpecialization());
		return doctorDto;
	}
	
	public Doctor dtoToDoctor(DoctorDto doctorDto) {
		Doctor doctor = this.modelMapper.map(doctorDto,Doctor.class);

	//	doctor.setId(doctorDto.getId());
	//	doctor.setFirstName(doctorDto.getFirstName());
	//	doctor.setLastName(doctorDto.getLastName());
	//	doctor.setSpecialization(doctorDto.getSpecialization());
		return doctor;
	}
}
