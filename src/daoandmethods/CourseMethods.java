
package daoandmethods;


public class CourseMethods {
    
    static CourseDAO courseDAO = new CourseDAO();

    
    public static void addCourse(String name) {
        
        courseDAO.addCourse(name);
    }

    public static void addExistingCourseToNewTeacher(int courseID, String nameOfNewTeacher) {
        
        courseDAO.addExistingCourseToNewTeacher(courseID, nameOfNewTeacher);
    }

    public static void showAllCourses() {
        
        courseDAO.showAllCourses();
    }

    public static void addNewCourseToExistingTeacher(String newCourse, int teacherID) {
        
        courseDAO.addNewCourseToExistingTeacher(newCourse, teacherID);
    }

    public static void removeACourseFromTeacher(String course, int teacherId) {
        
        courseDAO.removeACourseFromTeacher(course, teacherId);
    }

    public static void removeACourse(int id) {
        
        courseDAO.removeACourse(id);
    }

    public static void updateCourseName(int courseID, String newName) {
        
        courseDAO.updateCourseName(courseID, newName);
    }

    public static void addNewTeacherToExistingCourse(int courseID, String name) {
        
        courseDAO.addNewTeacherToExistingCourse(courseID, name);
    }

    public static void showAllTeachersOfACourse(int courseID) {
        
        courseDAO.showAllTeachersOfACourse(courseID);
    }
    
}
