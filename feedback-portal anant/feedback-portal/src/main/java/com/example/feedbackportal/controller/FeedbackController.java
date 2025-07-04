package com.example.feedbackportal.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.feedbackportal.model.Feedback;
import com.example.feedbackportal.service.FeedbackService;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Feedback> getByCourse(@PathVariable String courseId) {
        return service.findByCourseId(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback create(@Valid @RequestBody Feedback feedback) {
        return service.save(feedback);
    }

    @PutMapping("/{id}")
    public Feedback update(@PathVariable Long id, @Valid @RequestBody Feedback feedback) {
        return service.update(id, feedback);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
