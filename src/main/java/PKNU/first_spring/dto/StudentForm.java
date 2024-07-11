package PKNU.first_spring.dto;

import java.util.Date;

public record StudentForm(String student_name, String email, Date birth_date) {
}
