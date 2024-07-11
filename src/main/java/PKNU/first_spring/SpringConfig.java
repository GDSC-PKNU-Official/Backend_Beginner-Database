//package PKNU.first_spring;
//
//import PKNU.first_spring.repository.*;
//import PKNU.first_spring.service.CourseService;
//import PKNU.first_spring.service.MemberService;
//import PKNU.first_spring.service.QuizService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository();
//    }
//
//    @Bean
//    public CourseRepository courseRepository() {
//        return new JpaCourseRepository();
//    }
//
//    @Bean
//    public CourseService courseService() {
//        return new CourseService(memberRepository());
//    }
//
//    @Bean
//    public QuizService quizService() {
//        return new QuizService();
//    }
//}
