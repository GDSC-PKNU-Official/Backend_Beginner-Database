package PKNU.first_spring.controller;

import PKNU.first_spring.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public String quiz() {
        return "quiz/quizForm";
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam("answer") String answer) {
        if (quizService.isCorrect(answer)) {
            return "quiz/correctForm";
        } else {
            return "quiz/incorrectForm";
        }
    }
}
