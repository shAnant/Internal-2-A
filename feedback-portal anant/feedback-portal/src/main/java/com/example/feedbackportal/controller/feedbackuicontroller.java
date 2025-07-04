package com.example.feedbackportal.controller;

import com.example.feedbackportal.model.Feedback;
import com.example.feedbackportal.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackUIController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/feedbacks-ui")
    public String showFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "feedbacks";
    }

    @GetMapping("/feedbacks-ui/new")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "new-feedback";
    }

    @PostMapping("/feedbacks-ui")
    public String saveFeedback(@ModelAttribute Feedback feedback) {
        feedbackRepository.save(feedback);
        return "redirect:/feedbacks-ui";
    }

    @PostMapping("/feedbacks-ui/delete/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        feedbackRepository.deleteById(id);
        return "redirect:/feedbacks-ui";
    }
}