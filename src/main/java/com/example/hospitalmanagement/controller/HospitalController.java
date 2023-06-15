package com.example.hospitalmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalmanagement.payloads.DoctorDto;
import com.example.hospitalmanagement.payloads.PatientDto;
import com.example.hospitalmanagement.service.DoctorService;
import com.example.hospitalmanagement.service.PatientService;

	@RestController
	@RequestMapping("/api/hospital")
	public class HospitalController {

	    @Autowired
	    private PatientService patientService;

	    @Autowired
	    private DoctorService doctorService;

	    public HospitalController(DoctorService doctorService) {
	        this.doctorService = doctorService;
	    }
	        
	    //  GETTING all patients
	    @GetMapping("/patients")
	    public ResponseEntity<List<PatientDto>> getAllPatients() {
	        List<PatientDto> patients = patientService.getAllPatients();
	        return new ResponseEntity<>(patients, HttpStatus.OK);
	    }

    //  GETTING a specific patient by ID
	   @GetMapping("/patients/{id}")
        public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
	        PatientDto patient = patientService.getPatientById(id);
	        return new ResponseEntity<>(patient, HttpStatus.OK);
	    }

	    // CREATING a new patient
	    @PostMapping("/patients")
	    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
	        PatientDto createdPatient = this.patientService.createPatient(patientDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
	    }

	    // UPDATING an existing patient
	    @PutMapping("/patients/{id}")
	    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patienDto) {
	        PatientDto updatedpatient = this.patientService.updatePatient(patienDto, patientId);
	        return ResponseEntity.ok(updatedpatient);
	    }

	    //  DELETING a patient
	    @DeleteMapping("/patients/{id}")
	    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
	        patientService.deletePatient(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
//----------------------------DOCTOR-----------------------------------------------
	    
	    //  GETTING all doctors
	    @GetMapping("/doctors")
	    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
	        List<DoctorDto> doctors = doctorService.getAllDoctors();
	        return new ResponseEntity<>(doctors, HttpStatus.OK);
	    }

	    // GETTING a specific doctor by ID
	    @GetMapping("/doctors/{id}")
	    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
	        DoctorDto doctor = doctorService.getDoctorById(id);
	        return new ResponseEntity<>(doctor, HttpStatus.OK);
	    }


	    //  CREATING a new doctor
	    @PostMapping("/doctors")
	    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
	        DoctorDto createdDoctor = this.doctorService.createDoctor(doctorDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
	    }

	    // UPDATING an existing doctor
	    @PutMapping("/doctors/{id}")
	    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
	        DoctorDto updatedoctor = this.doctorService.updateDoctor(doctorDto, doctorId);
	        return ResponseEntity.ok(updatedoctor);
	    }

	    // DELETE doctor
	    @DeleteMapping("/doctors/{id}")
	    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
	        doctorService.deleteDoctor(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}  
