package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Course;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class JpaCourseRepository implements CourseRepository {

    EntityManager em;

    public JpaCourseRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Course saveCourse(Course course) {
        em.persist(course);
        return course;
    }

    @Override
    public void deleteCourse(Course course) {
        if (em.contains(course)) {
            em.remove(course);
        } else {
            Course managedCourse = em.merge(course);
            em.remove(managedCourse);
        }
    }

    @Override
    public Optional<Course> findByName(String name) {
        List<Course> result = em.createQuery("SELECT c FROM Course c WHERE c.course_name = :name", Course.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Course> findById(Long id) {
        List<Course> result = em.createQuery("SELECT c FROM Course c WHERE c.course_id = :id", Course.class)
                .setParameter("id", id)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class)
                .getResultList();
    }
}
