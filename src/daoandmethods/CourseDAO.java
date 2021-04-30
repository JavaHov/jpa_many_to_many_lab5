
package daoandmethods;

import static daoandmethods.TeacherDAO.emf;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelsource.domain.Course;
import modelsource.domain.Teacher;


public class CourseDAO {

    
    void addCourse(String name) {
        
        EntityManager em = emf.createEntityManager();
        
        Course c = new Course(name);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();   
    }

    void addExistingCourseToNewTeacher(int courseID, String nameOfNewTeacher) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = new Teacher(nameOfNewTeacher);
        
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        em.persist(teacher);
        teacher.addCourse(course);
        em.getTransaction().commit();
        em.close();
        
    }

    void showAllCourses() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();
        
        courses.stream().forEach(c -> System.out.println(c));
    }

    void addNewCourseToExistingTeacher(String newCourse, int teacherID) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = new Course(newCourse);
        
        Teacher teacher = em.find(Teacher.class, teacherID);
        
        teacher.addCourse(course);
        
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void removeACourseFromTeacher(String course, int teacherId) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher t = em.find(Teacher.class, teacherId);
        
        TypedQuery<Course> courseQuery = em.createQuery("SELECT c FROM Course c WHERE c.name=:course", Course.class);
        courseQuery.setParameter("course", course);
        Course c = courseQuery.getSingleResult();
        
        em.getTransaction().begin();
        t.removeCourse(c);
        em.getTransaction().commit();
        em.close();
    }

    void removeACourse(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, id);
        
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        em.close();
    }

    void updateCourseName(int courseID, String newName) {

        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        
        em.getTransaction().begin();
        course.setName(newName);
        em.getTransaction().commit();
        em.close();        
        
    }

    void addNewTeacherToExistingCourse(int courseID, String name) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        
        Teacher teacher = new Teacher(name);
        teacher.addCourse(course);// Addade course till teacher här...
        
        em.getTransaction().begin();
        em.persist(teacher); // Persistar teacher här...
        em.getTransaction().commit();
        em.close();        
    }

    void showAllTeachersOfACourse(int courseID) {
        
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, courseID);
        
        List<Teacher> teachers = course.getTeachers();
        
        System.out.println("Teachers in " + course);
        
        teachers.stream().map(t -> t.getName()).forEach(n -> System.out.println(n));
    }
    
}
