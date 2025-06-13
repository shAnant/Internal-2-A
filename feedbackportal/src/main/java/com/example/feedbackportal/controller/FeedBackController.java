package com.example.feedbackportal.controller;

import com.example.feedbackportal.model.FeedBack;
import com.example.feedbackportal.service.FeedBackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService service;

    public FeedBackController(FeedBackService service) {
        this.service = service;
    }

    @GetMapping
    public List<FeedBack> getAllFeedback() {
        return service.getAllFeedback();
    }

    @GetMapping("/{id}")
    public Optional<FeedBack> getFeedbackById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/course/{coursed}")
    public List<FeedBack> getFeedbackByCourse(@PathVariable String coursed) {
        return service.getByCoursed(coursed);
    }

    @PostMapping
    public FeedBack submitFeedback(@RequestBody FeedBack feedback) {
        return service.addFeedback(feedback);
    }

    @PutMapping("/{id}")
    public FeedBack updateFeedback(@PathVariable Long id, @RequestBody FeedBack feedback) {
        return service.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        service.deleteFeedback(id);
        return "Feedback with ID " + id + " deleted successfully.";
    }
}
