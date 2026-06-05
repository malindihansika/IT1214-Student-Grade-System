// src/StudentGradeSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeSystem {
    private ArrayList<Student> students;

    public StudentGradeSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String studentName, int marks) {
        students.add(new Student(studentId, studentName, marks));
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getStudentName() + ", Marks: " + student.getMarks());
        }
    }

    public Student searchStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public double calculateAverageMarks() {
        if (students.isEmpty()) {
            return 0.0;
        }
        int totalMarks = 0;
        for (Student student : students) {
            totalMarks += student.getMarks();
        }
        return (double) totalMarks / students.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeSystem sgs = new StudentGradeSystem();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = scanner.nextInt();
                    sgs.addStudent(id, name, marks);
                    break;
                case 2:
                    sgs.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = sgs.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Found: " + foundStudent.getStudentName() + ", Marks: " + foundStudent.getMarks());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    double average = sgs.calculateAverageMarks();
                    System.out.printf("Average Marks: %.2f\n", average);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }
}
