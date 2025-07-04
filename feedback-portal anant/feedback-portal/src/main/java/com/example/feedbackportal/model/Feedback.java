package com.example.feedbackportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "courseId is mandatory")
    private String courseId;

    @Min(value = 1)
    @Max(value = 5)
    private int rating;

    private String comment;

    // Constructors
    public Feedback() {}

    public Feedback(Long id, String courseId, int rating, String comment) {
        this.id = id;
        this.courseId = courseId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
