public class Course {
    
    private double grade;
    private String courseName;
    
    /**
     * Constructor with no perameters, sets values to Unknown
     * -1 in grade shows up as "Uknown" when printed
     */
    public Course(){
        grade = -1;
        courseName = "Unknown";
    }
    /**
     * Constructor which sets grade, but defaults the name to Unknown
     * @param g the percentage grade to be set
     */
    public Course(double g){
        grade = g;
        courseName = "Unknown";
    }
    /**
     * Constructor setting only the name, defaulting grade to -1
     * @param n the name for the course
     */
    public Course(String n){
        grade = -1;
        courseName = n;
    }
    /**
     * The Constructor which will be mostly used, setting both name and grade
     * @param g the percentage grade
     * @param n the name of the course
     */
    public Course(double g, String n){
        grade = g;
        courseName = n;
    }
    
    /**
     * Returns the courses name as a string
     * @return The course name
     */
    public String getCourseName(){
        return courseName;
    }
    /**
     * Overrides the course name
     * @param n the new course name
     */
    public void setCourseName(String n){
        courseName = n;
    }
    
    /**
     * Returns the courses grade as a double
     * @return the grade as a double
     */
    public double getGrade(){
        return grade;
    }
    /**
     * Changes the courses grade
     * @param g the new grade
     */
    public void setGrade(double g){
        grade = g;
    }
    
    /**
     * Returns the course name and grade
     * If the grade is below 0, it will print as "Unknown"
     * @return the course name and grade
     */
     @Override
    public String toString(){
        String gTemp = grade+"";
        if(grade < 0){
            gTemp = "Unknown";
        }
        return "Course Name: "+courseName+"\nGrade: "+gTemp;
    }
}