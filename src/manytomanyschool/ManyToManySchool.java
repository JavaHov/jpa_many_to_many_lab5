/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manytomanyschool;

import daoandmethods.CourseMethods;
import daoandmethods.TeacherDAO;
import daoandmethods.TeacherMethods;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManyToManySchool {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    static boolean loop = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {



        while (loop) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("\n========================================");
        System.out.println("                 Menu                 ");
        System.out.println("========================================");
        System.out.println("1.Add course");
        System.out.println("2.Add teacher");
        System.out.println("3.Add existing course to new teacher");
        System.out.println("4.Add existing course to existing teacher");
        System.out.println("5.Add new course to existing teacher");
        System.out.println("6.Add new teacher and course");
        System.out.println("7.Remove a course from a teacher/Remove a teacher from a course");
        System.out.println("8.Remove a teacher");
        System.out.println("9.Remove a course");
        System.out.println("10.Show all teachers");
        System.out.println("11.Show all courses");
        System.out.println("12.Update teacher name");
        System.out.println("13.Update course name");
        System.out.println("14.Show all courses of a teacher");
        System.out.println("15.Show all teachers of a course");
        System.out.println("16.Add new teacher to existing course");
        System.out.println("0. Exit");
//        System.out.println("========================================");
        System.out.print("Make your choice:");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
//
            case 1:
                addCourse();

                break;
            case 2:
                addTeacher();
                break;
            case 3:
                addExistingCourseToNewTeacher();
                break;
            case 4:
                addExistingCourseToExistingTeacher();
                break;
            case 5:
                addNewCourseToExistingTeacher();
                break;
            case 6:
                addNewTeacherAndNewCourse();
                break;
            case 7:
                removeACourseFromTeacher();
           
                break;
            case 8:
                removeATeacher();
                break;
            case 9:
                removeACourse();
                break;

            case 10:
                showAllTeachers();
                break;

            case 11:
                showAllCourses();
                break;

            case 12:
                updateTeacherName();
                break;

            case 13:
                updateCourseName();
                break;
            case 14:
                showAllCoursesOfATeacher();
                break;
            case 15:
//                showAllTeachersOfACourse();
                break;
            case 16:
                addNewTeacherToExistingCourse();

            case 0:
                loop = false;
                TeacherDAO.emf.close();               
                break;
            default:
                System.out.println("No such choice!");
        }
    }

    private static void addCourse() {
        
        System.out.println("Name of Course:");
        String name = sc.nextLine();
        
        CourseMethods.addCourse(name);
    }

    private static void addTeacher() {
        
        System.out.println("Name of Teacher:");
        String name = sc.nextLine();
        
        TeacherMethods.addTeacher(name);
    }

    private static void addExistingCourseToNewTeacher() {
        
        System.out.println("ID of existing Course:");
        int courseID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Name of new Teacher:");
        String nameOfNewTeacher = sc.nextLine();
        
        CourseMethods.addExistingCourseToNewTeacher(courseID, nameOfNewTeacher);
    }

    private static void showAllTeachers() {
        
        TeacherMethods.showAllTeachers();
    }

    private static void showAllCourses() {
        
        CourseMethods.showAllCourses();
    }

    private static void addExistingCourseToExistingTeacher() {
        
        System.out.println("ID of existing Course:");
        int courseID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("ID of existing Teacher:");
        int teacherID = sc.nextInt();
        sc.nextLine();
        
        TeacherMethods.addExistingCourseToExistingTeacher(courseID, teacherID);
    }

    private static void addNewCourseToExistingTeacher() {
        
        System.out.println("Name of new Course:");
        String newCourse = sc.nextLine();
        
        System.out.println("ID of existing Teacher:");
        int teacherID = sc.nextInt();
        sc.nextLine();
        
        CourseMethods.addNewCourseToExistingTeacher(newCourse, teacherID);
    }

    private static void addNewTeacherAndNewCourse() {
        
        System.out.println("New Teacher:");
        String newTeacher = sc.nextLine();
        
        System.out.println("New Course:");
        String newCourse = sc.nextLine();
        
        TeacherMethods.addNewTeacherAndNewCourse(newTeacher, newCourse);
    }

    private static void removeACourseFromTeacher() {
        
        System.out.println("Course to remove:");
        String course = sc.nextLine();
        
        System.out.println("ID of Teacher:");
        int teacherId = sc.nextInt();
        sc.nextLine();
        
        CourseMethods.removeACourseFromTeacher(course, teacherId);
    }

    private static void removeATeacher() {
        
        System.out.println("ID of Teacher to remove:");
        int id = sc.nextInt();
        sc.nextLine();
        
        TeacherMethods.removeATeacher(id);
    }

    private static void removeACourse() {
        
        System.out.println("ID of Course to remove:");
        int id = sc.nextInt();
        sc.nextLine();
        
        CourseMethods.removeACourse(id);
    }

    private static void updateTeacherName() {
        
        System.out.println("ID of Teacher:");
        int teacherID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("New name for Teacher:");
        String newName = sc.nextLine();
        
        TeacherMethods.updateTeacherName(teacherID, newName);
    }

    private static void updateCourseName() {
        
        System.out.println("ID of Course:");
        int courseID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("New name for Course:");
        String newName = sc.nextLine();
        
        CourseMethods.updateCourseName(courseID, newName);
    }

    private static void showAllCoursesOfATeacher() {
        
        System.out.println("ID of Teacher:");
        int teacherID = sc.nextInt();
        sc.nextLine();
        
        TeacherMethods.showAllCoursesOfATeacher(teacherID);
    }

    private static void addNewTeacherToExistingCourse() {
        
        System.out.println("ID of Course:");
        int courseID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Name of new Teacher:");
        String name = sc.nextLine();
        
        CourseMethods.addNewTeacherToExistingCourse(courseID, name);
    }

}
