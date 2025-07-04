package com.example.feedbackportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.feedbackportal.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByCourseId(String courseId);
}
