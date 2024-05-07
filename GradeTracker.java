import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class GradeTracker {
    private static ArrayList<String> studentNames = new ArrayList<>();
    private static ArrayList<Double> grades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("-----------------------");
            System.out.println("1. Add Student Grade");
            System.out.println("2. Display Grades");
            System.out.println("3. Calculate Statistics");
            System.out.println("4. Save/Load Data");
            System.out.println("5. Quit");
            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    displayGrades();
                    break;
                case 3:
                    calculateStats();
                    break;
                case 4:
                    saveOrLoadData();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }

    private static void addGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the student's name: ");
        String name = sc.next();
        studentNames.add(name);

        System.out.print("Enter the student's grade: ");
        double grade = sc.nextDouble();
        grades.add(grade);
    }

    private static void displayGrades() {
        System.out.println("Student Grades:");
        for(int i=0; i<studentNames.size(); i++) {
            System.out.println(studentNames.get(i) + ": " + grades.get(i));
        }
    }

    private static void calculateStats() {
        double sum = 0.0;
        double max = grades.get(0);
        double min = grades.get(0);

        for (double grade : grades) {
            sum += grade;
            if (grade > max) {
                max = grade;
            }
            if (grade < min) {
                min = grade;
            }
        }

        double avg = sum / grades.size();

        System.out.println("Average: " + avg);
        System.out.println("Highest: " + max);
        System.out.println("Lowest: " + min);
    }

    private static void saveOrLoadData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Save Data");
        System.out.println("2. Load Data");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        if (choice == 1) {
            saveData();
        } else if (choice == 2) {
            loadData();
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void saveData() {
        try (PrintWriter out = new PrintWriter(new File("grades.csv"))) {

            out.println("Student,Grade");
            for(int i=0; i<studentNames.size(); i++) {
                out.println(studentNames.get(i) + "," + grades.get(i));
            }

            System.out.println("Data saved to grades.csv");

        } catch (FileNotFoundException e) {
            System.out.println("Error saving grades data: " + e.getMessage());
        }
    }

    private static void loadData() {
        try (Scanner scanner = new Scanner(new File("grades.csv"));){

            scanner.nextLine(); // skip header row

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] values = line.split(",");
                studentNames.add(values[0]);
                grades.add(Double.parseDouble(values[1]));
            }

            System.out.println("Data loaded from grades.csv");

        } catch (FileNotFoundException e) {
            System.out.println("Error loading grades data: " + e.getMessage());
        }
    }
}