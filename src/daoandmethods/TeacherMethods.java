
package daoandmethods;

import javax.persistence.Persistence;


public class TeacherMethods {
    
    
    
    static TeacherDAO teacherDAO = new TeacherDAO();

    public static void addTeacher(String name) {
        
        teacherDAO.addTeacher(name);
    }

    public static void showAllTeachers() {
        
        teacherDAO.showAllTeachers();
    }

    public static void addExistingCourseToExistingTeacher(int courseID, int teacherID) {
        
        teacherDAO.addExistingCourseToExistingTeacher(courseID, teacherID);
    }

    public static void addNewTeacherAndNewCourse(String newTeacher, String newCourse) {
        
        teacherDAO.addNewTeacherAndNewCourse(newTeacher, newCourse);
    }

    public static void removeATeacher(int id) {
        
        teacherDAO.removeATeacher(id);
    }

    public static void updateTeacherName(int teacherID, String newName) {
        
        teacherDAO.updateTeacherName(teacherID, newName);
    }

    public static void showAllCoursesOfATeacher(int teacherID) {
        
        teacherDAO.showAllCoursesOfATeacher(teacherID);
    }
    
    
    
}
