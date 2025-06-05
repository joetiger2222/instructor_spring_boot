package com.example.instructor.instructor.DTOs;

public class GetInstructorDetailsInInstructorDto {
    private String youtube_channel;
    private String hobby;

    public GetInstructorDetailsInInstructorDto() {
    }

    public GetInstructorDetailsInInstructorDto(String youtube_channel, String hobby) {
        this.youtube_channel = youtube_channel;
        this.hobby = hobby;
    }

    public String getYoutube_channel() {
        return youtube_channel;
    }

    public void setYoutube_channel(String youtube_channel) {
        this.youtube_channel = youtube_channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
