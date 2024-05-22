import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class with a majority of the methods for this program
 * Mostly takes player input to store data, which can be compiled and viewed afterwards
 * Works with the Course class, creating an ArrayList of Course objects to work with
 */
public class Tracker {
    Scanner scan = new Scanner(System.in);
    
    private ArrayList<Course> courses = new ArrayList<>();
    private double GPA = 0;
    private double gradeAverage = 0;
    
    /**
     * The only constructor, nothing fancy needed
     */
    public Tracker(){}
    
    /**
     * Returns the gradeAverage as a double, used for math and such
     * @return the users average percentage grade
     */
    public double getGradeAverage(){
        return gradeAverage;
    }
    
    /**
     * Returns the GPA as a double, to be used for math and the likes
     * @return the users GPA as a double
     */
    public double getGPA(){
        return GPA;
    }
    
    /**
     * Checks if the user has added any courses, and prints their gradeAverage if they have
     */
    public void viewGradeAverage(){
        if(courses.size() == 0){
            System.out.println("You haven't added any courses to calculate an average.");
        }
        else{
            System.out.println("Your current average grade is "+Math.round(gradeAverage*100)/100.0+"%.");// Rounds to nearest 100th
        }
    }
    
    /**
     * Checks if the user has added any courses, and prints their GPA if they have
     */
    public void viewGPA(){
        if(courses.size() == 0){
            System.out.println("You haven't added any courses to calculate your GPA.");
        }
        else{
            System.out.println("Your current GPA is "+GPA+".");
        }
    }
    
    /**
     * Lets the user add a course to their ArrayList
     * Checks if their input name already exists, and gives the option to override or cancel
     */
    public void addCourse(){
        boolean hasFinal = false;
        double grade = -1;
        int nameChoice = 0;
        String cName;
        String finalAnswer;
        
        System.out.println("What is the course named?");
        cName = scan.nextLine();
        
        // Checks the list of courses already made, if it finds a duplicate name, asks if they want to override the old grade
        for(int i = 0; i < courses.size(); i++){
            if(cName.equalsIgnoreCase(courses.get(i).getCourseName())){
                System.out.println("There is already a course with this name,\nwhat would you like to do?\n1. Cancel addition\n2. Override original course");
                
                while (nameChoice != 1 && nameChoice != 2){
                    if(scan.hasNextInt()){
                        nameChoice = scan.nextInt();
                    }
                    else{
                        System.out.println("Invalid input, please pick 1 or 2");
                        scan.next();
                    }
                }
                
                if(nameChoice == 1){
                    System.out.println("Addition Cancelled.");
                    return;
                }
                else if(nameChoice == 2){
                    courses.remove(i);
                }
            }
        }
        
        System.out.println("Alright, what is your current/final grade?\n(Input the percentage)");
        while (grade < 0){ // Loops input until they enter a positive grade
            if(scan.hasNextDouble()){
                grade = scan.nextDouble();
                if(grade < 0){
                    System.out.println("Can't input a negative grade.");
                }
            }
            else{
                System.out.println("Invalid input, please type a number.");
                scan.next();
            }
        }
        scan.nextLine(); // Clears the scanner
        
        // Creates a course object using the inputs and adds it to the ArrayList
        Course newCourse = new Course(grade, cName);
        courses.add(newCourse);
        System.out.println("Course added successfully.");
    }
    
    /**
     * Lets the user remove existing courses
     * If no courses exist, it tells the user and ends the method
     */
    public void removeCourse(){
        String cName;
        int startSize = courses.size();
        
        // Doesn't continue if the ArrayList has 0 classes
        if(courses.size() == 0){
            System.out.println("You haven't added any courses to be removed.");
        }
        
        else{
            System.out.println("What is the name of the course you want to remove from the list?");
            cName = scan.nextLine();
            
            for(int i = 0; i < courses.size(); i++){
                if(cName.equalsIgnoreCase(courses.get(i).getCourseName())){
                    courses.remove(i);
                    System.out.println("Course removed successfully.");
                }
            }
            
            // If nothing was removed, it tells the user no course was found
            if(startSize == courses.size()){
                System.out.println("Could not find a course with that name.");
            }
        }
    }
    
    /**
     * Outputs every course the user has made so far, alongside it's percentage grade
     * If no courses exist, it tells the user and stops
     */
    public void viewCourses(){
        // Doesnt work if the user has no courses
        if(courses.size() == 0){
            System.out.println("You haven't added any courses to be viewed.");
        }
        else{
            System.out.println("Course, Grade:");
            for(Course c : courses){
                System.out.println(c.getCourseName() +", "+c.getGrade());
            }
        }
    }
    
    /**
     * Updates the users GPA and gradeAverage, allowing them to be print later
     * For GPA, uses a 1.0(50%-59%) to 4.5(100%) scale 
     */
    public void updateGPA(){
        double gradePointTotal = 0.0;
        int cHours = 0;
        gradeAverage = 0;
        
        for(Course c : courses){
            gradeAverage += c.getGrade();
            // Adding the corresponding Grade Point amount for each % grade
            if(c.getGrade() < 50){
                break;
            }
            else if(c.getGrade() < 60){
                gradePointTotal += 1;
            }
            else if(c.getGrade() < 65){
                gradePointTotal += 2;
            }
            else if(c.getGrade() < 70){
                gradePointTotal += 2.5;
            }
            else if(c.getGrade() < 75){
                gradePointTotal += 3;
            }
            else if (c.getGrade() < 80){
                gradePointTotal += 3.5;
            }
            else if (c.getGrade() < 90){
                gradePointTotal += 4;
            }
            else if (c.getGrade() < 100){
                gradePointTotal += 4.5;
            }
        }
        gradeAverage = gradeAverage/courses.size();
        GPA = Math.round((gradePointTotal /= courses.size())*10)/10.0;
    }
}