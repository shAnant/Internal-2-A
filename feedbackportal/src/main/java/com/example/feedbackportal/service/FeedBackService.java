package com.example.feedbackportal.service;

import com.example.feedbackportal.model.FeedBack;
import com.example.feedbackportal.repository.FeedBackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackService {

    private final FeedBackRepository repository;

    public FeedBackService(FeedBackRepository repository) {
        this.repository = repository;
    }

    public List<FeedBack> getAllFeedback() {
        return repository.findAll();
    }

    public Optional<FeedBack> getById(Long id) {
        return repository.findById(id);
    }

    public List<FeedBack> getByCoursed(String coursed) {
        return repository.findByCoursed(coursed);
    }

    public FeedBack addFeedback(FeedBack feedback) {
        return repository.save(feedback);
    }

    public FeedBack updateFeedback(Long id, FeedBack updatedFeedback) {
        return repository.findById(id)
            .map(existing -> {
                existing.setCoursed(updatedFeedback.getCoursed());
                existing.setRating(updatedFeedback.getRating());
                existing.setComment(updatedFeedback.getComment());
                return repository.save(existing);
            }).orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    public void deleteFeedback(Long id) {
        repository.deleteById(id);
    }
}
