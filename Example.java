/**

 import java.util.Scanner;
 import java.util.ArrayList;
 import java.io.*;

 public class StudentGradeTracker {

 private static ArrayList<Double> grades = new ArrayList<>();

 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int choice = 0;

 while(choice != 6) {
 System.out.println("\nStudent Grade Tracker");
 System.out.println("1. Add Student Grade");
 System.out.println("2. Display Grades");
 System.out.println("3. Calculate Statistics");
 System.out.println("4. Generate Report");
 System.out.println("5. Save/Load Data");
 System.out.println("6. Quit");
 System.out.print("\nEnter your choice: ");

 choice = sc.nextInt();

 switch(choice) {
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
 generateReport();
 break;
 case 5:
 saveOrLoadData();
 break;
 case 6:
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
 System.out.print("Enter student grade: ");
 double grade = sc.nextDouble();
 grades.add(grade);
 System.out.println("Grade added!");
 }

 private static void displayGrades() {
 System.out.println("Student Grades:");
 for(double grade : grades) {
 System.out.println(grade);
 }
 }

 private static void calculateStats() {
 double sum = 0.0;
 double max = grades.get(0);
 double min = grades.get(0);

 for(double grade : grades) {
 sum += grade;
 if(grade > max) {
 max = grade;
 }
 if(grade < min) {
 min = grade;
 }
 }

 double avg = sum / grades.size();

 System.out.println("Average: " + avg);
 System.out.println("Highest: " + max);
 System.out.println("Lowest: " + min);
 }

 private static void generateReport() {
 calculateStats();
 System.out.println("\nGrade Report:");
 System.out.println("Average: " + grades.stream().mapToDouble(a -> a).average().orElse(0));
 System.out.println("Highest: " + Collections.max(grades));
 System.out.println("Lowest: " + Collections.min(grades));
 }

 private static void saveOrLoadData() {
 Scanner sc = new Scanner(System.in);
 System.out.println("1. Save Data");
 System.out.println("2. Load Data");
 System.out.print("Enter your choice: ");

 int choice = sc.nextInt();

 if(choice == 1) {
 saveData();
 } else if(choice == 2) {
 loadData();
 } else {
 System.out.println("Invalid choice");
 }
 }

 private static void saveData() {
 try {
 FileOutputStream fos = new FileOutputStream("grades.dat");
 ObjectOutputStream oos = new ObjectOutputStream(fos);
 oos.writeObject(grades);
 oos.close();
 fos.close();
 System.out.println("Data saved to grades.dat");
 } catch (IOException e) {
 e.printStackTrace();
 }
 }

 private static void loadData() {
 try {
 FileInputStream fis = new FileInputStream("grades.dat");
 ObjectInputStream ois = new ObjectInputStream(fis);
 grades = (ArrayList)ois.readObject();
 ois.close();
 fis.close();
 System.out.println("Data loaded from grades.dat");
 } catch (IOException | ClassNotFoundException e) {
 e.printStackTrace();
 }
 }
 }


 **/