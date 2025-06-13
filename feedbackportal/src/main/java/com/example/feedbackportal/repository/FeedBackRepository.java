package com.example.feedbackportal.repository;

import com.example.feedbackportal.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findByCoursed(String coursed);
}
