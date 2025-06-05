package com.example.instructor.instructor.DTOs;

import com.example.instructor.instructor.Entities.InstructorDetails;

public class GetAllInstructorsDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private GetInstructorDetailsInInstructorDto instructorDetails;
    public GetAllInstructorsDto() {
    }

    public GetAllInstructorsDto(int id, String firstName, String lastName, String email,GetInstructorDetailsInInstructorDto instructorDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetails=instructorDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GetInstructorDetailsInInstructorDto getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(GetInstructorDetailsInInstructorDto instructorDetails) {
        this.instructorDetails = instructorDetails;
    }
}
