package com.example.hospitalmanagement.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
	
    @Data
	@Entity
	@Table(name = "doctors")
	public class Doctor {
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(nullable = false)
	  private String firstName;
	  
	  @Column(nullable = false)
	  private String lastName;
	  
	  @Column(nullable = false)
	  private String specialization;
	  
	  // Other doctor attributes and relationships
	  
	  public Doctor() {
			super();
			
		}

	  public Doctor(Long id, String firstName, String lastName, String specialization) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.specialization = specialization;
		}
	  
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

	  public String getSpecialization() {
	    return specialization;
	  }

	  public void setSpecialization(String specialization) {
	    this.specialization = specialization;
	  }

	  // Override toString() for better logging or debugging
	  
	  @Override
	  public String toString() {
	    return "Doctor{" +
	            "id=" + id +
	            ", firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", specialization='" + specialization + '\'' +
	       
	            '}';
	  }
	}
