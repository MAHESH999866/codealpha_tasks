import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Student {
        String name;
        double score;

        Student(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Student Grade Tracker: ");

        while (running) {
            System.out.println("\n1. Add Student & Grade");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine(); // Consume the leftover newline
                    students.add(new Student(name, score));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    displayReport(students);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    public static void displayReport(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        double sum = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        System.out.println("\n Summary Report :");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.score);
            sum += s.score;
            if (s.score > highest) highest = s.score;
            if (s.score < lowest) lowest = s.score;
        }

        double average = sum / students.size();

        System.out.println("----------------------");
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}