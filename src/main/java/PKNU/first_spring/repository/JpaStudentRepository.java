package PKNU.first_spring.repository;

import PKNU.first_spring.domain.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class JpaStudentRepository implements StudentRepository {

    EntityManager em;

    public JpaStudentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student save(Student student) {
        em.persist(student);
        return null;
    }

    @Override
    public void deleteStudent(Student student) {
        if (em.contains(student)) {
            em.remove(student);
        } else {
            Student managedStudent = em.merge(student);
            em.remove(managedStudent);
        }
    }

    @Override
    public Optional<Student> findByName(String name) {
        List<Student> result = em.createQuery("SELECT s FROM Student s WHERE s.student_name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Student> findById(Long id) {
        List<Student> result = em.createQuery("SELECT s FROM Student s WHERE s.student_id = :id", Student.class)
                .setParameter("id", id)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT c FROM Student c", Student.class)
                .getResultList();
    }
}
