package com.example.instructor.instructor.DTOs;

import com.example.instructor.instructor.Entities.Review;

import java.util.List;

public class GetAllCoursesDto {
    private String name;
    private int id;
    private List<Review> reviwes;

    public GetAllCoursesDto(String name, int id,List<Review> reviwes) {
        this.name = name;
        this.id = id;
        this.reviwes=reviwes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getReviwes() {
        return reviwes;
    }

    public void setReviwes(List<Review> reviwes) {
        this.reviwes = reviwes;
    }
}
