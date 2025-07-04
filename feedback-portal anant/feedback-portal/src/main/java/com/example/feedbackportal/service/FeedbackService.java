package com.example.feedbackportal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.feedbackportal.exception.ResourceNotFoundException;
import com.example.feedbackportal.model.Feedback;
import com.example.feedbackportal.repository.FeedbackRepository;

@Service
@Transactional
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public Feedback findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", id));
    }

    public List<Feedback> findByCourseId(String courseId) {
        return repository.findByCourseId(courseId);
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public Feedback update(Long id, Feedback updated) {
        Feedback existing = findById(id);
        existing.setCourseId(updated.getCourseId());
        existing.setRating(updated.getRating());
        existing.setComment(updated.getComment());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Feedback existing = findById(id);
        repository.delete(existing);
    }
}
