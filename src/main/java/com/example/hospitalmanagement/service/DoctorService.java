package com.example.hospitalmanagement.service;

import java.util.List;
import com.example.hospitalmanagement.payloads.DoctorDto;

public interface DoctorService{
	
	DoctorDto createDoctor(DoctorDto doctor);
	
    DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId);
    
    DoctorDto getDoctorById(Long doctorId);
    
    List<DoctorDto> getAllDoctors();

	 void deleteDoctor(Long doctorId);
}

//UserDto registerNewUser(UserDto user);

//UserDto createUser(UserDto user);

//UserDto updateUser(UserDto user, Integer userId);

//UserDto getUserById(Integer userId);

//List<UserDto> getAllUsers();

//void deleteUser(Integer userId);