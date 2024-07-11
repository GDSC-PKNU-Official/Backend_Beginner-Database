package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Course;
import PKNU.first_spring.domain.Enrollment;
import PKNU.first_spring.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaEnrollmentRepository implements EnrollmentRepository {

    EntityManager em;

    public JpaEnrollmentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        em.persist(enrollment);
        return enrollment;
    }

    @Override
    public void deleteEnrollment(Enrollment enrollment) {
        if (em.contains(enrollment)) {
            em.remove(enrollment);
        } else {
            Enrollment managedEnrollment = em.merge(enrollment);
            em.remove(managedEnrollment);
        }
    }

    @Override
    public List<Student> findStudentInCourse(String courseName) {
        TypedQuery<Student> query = em.createQuery("select e.student FROM Enrollment e where e.course.course_name = :courseName", Student.class);
        query.setParameter("courseName", courseName);
        return query.getResultList();
    }
}
