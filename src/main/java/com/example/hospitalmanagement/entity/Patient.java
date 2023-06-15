package com.example.hospitalmanagement.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

    @Data
	@Entity
	@Table(name = "patients")
	public class Patient {

	  public Patient() {	
		}
	  
	  public Patient(Long id, String firstName, String lastName, String gender, LocalDate dateOfBirth) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
		}
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(nullable = false)
	  private String firstName;

	  @Column(nullable = false)
	  private String lastName;

	  @Column(nullable = true)
	  private String gender;

	  @Column(nullable = false)
	  private LocalDate dateOfBirth;
	  
	  // Getters and setters

	  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  public String getGender() {
	    return gender;
	  }

	  public void setGender(String gender) {
	    this.gender = gender;
	  }

	  public LocalDate getDateOfBirth() {
	    return dateOfBirth;
	  }

	  public void setDateOfBirth(LocalDate dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
	  }

	  // Override toString() for better logging or debugging

	  @Override
	  public String toString() {
	    return "Patient{" +
	            "id=" + id +
	            ", firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", gender='" + gender + '\'' +
	            ", dateOfBirth=" + dateOfBirth +
	            // Include other attributes
	            '}';
	  }
	}
