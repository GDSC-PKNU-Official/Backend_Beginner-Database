package PKNU.first_spring.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuizService {
    public boolean isCorrect(String answer) {
        return Objects.equals(answer, "한화 이글스") || Objects.equals(answer, "Hanwha Eagles");
    }
}
