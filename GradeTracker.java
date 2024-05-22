/*Cody Asher
May 2024
Program for friends & portfolio*/

import java.util.Scanner;

/**
 * The Class containing the basic user-interactions, asking which methods they'd like to run
 */
public class GradeTracker
{
    /**
     * Main, begins the program, runs a while loop until the user exits the program
     */
    public static void main(String[] args)
    {
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        Tracker user = new Tracker();
        
        // Asking the user which function of the program they'd like to use
        System.out.println("Welcome to a simple Grade and Course tracker,\nselect an option below.");
        while(true){
            System.out.println("1. Add a course\n2. Remove a course\n3. View courses\n4. View GPA\n5. View average grade\n6. Exit program");
            
            // Running the appropriate method based on user input
            if(scan.hasNextInt()){
                choice = scan.nextInt();
                scan.nextLine();
                
                if(choice == 1){
                    user.addCourse();
                    System.out.println();
                    user.updateGPA();
                } // If the user adds/removes a course, update their GPA and average grade
                else if(choice == 2){
                    user.removeCourse();
                    System.out.println();
                    user.updateGPA();
                }
                else if(choice == 3){
                    user.viewCourses();
                    System.out.println();
                }
                else if(choice == 4){
                    user.viewGPA();
                    System.out.println();
                }
                else if (choice == 5){
                    user.viewGradeAverage();
                    System.out.println();
                }
                else if(choice == 6){
                    return;
                }
                else{
                    System.out.println("Invalid choice, please input a number 1-5.");
                }
            } // If the user inputs something that isn't a number or is a number out of range, prints this error and asks for input again
            else{
                System.out.println("Invalid choice, please input a number 1-5.");
            }
            
            // Resetting the choice after running each method to avoid some issues
            choice = 0;
        }
    }
}
