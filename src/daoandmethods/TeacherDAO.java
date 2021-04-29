
package daoandmethods;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelsource.domain.Course;
import modelsource.domain.Teacher;


public class TeacherDAO {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addTeacher(String name) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher t = new Teacher(name);
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        
    }

    void showAllTeachers() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = query.getResultList();
        
        teachers.forEach(t -> System.out.println(t));
    }

    void addExistingCourseToExistingTeacher(int courseID, int teacherID) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, teacherID);
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        teacher.addCourse(course);
        em.getTransaction().commit();
        em.close();
    }

    void addNewTeacherAndNewCourse(String newTeacher, String newCourse) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = new Teacher(newTeacher);
        Course course = new Course(newCourse);
        
        teacher.addCourse(course);
        
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void removeATeacher(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, id);
        
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void updateTeacherName(int teacherID, String newName) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        em.getTransaction().begin();
        teacher.setName(newName);
        em.getTransaction().commit();
        em.close();
    }

    void showAllCoursesOfATeacher(int teacherID) {
 
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        List<Course> courses = teacher.getCourses();
        
        System.out.println("Teacher: " + teacher.getName());
        courses.stream().forEach(c -> System.out.println(c));
        
        
    }
    
    
    
}
