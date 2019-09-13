package CoreJava.Models;

public class Course {
	
	private String courseID;
	private String courseName;
	private String instructor;
	
    public Course(){
    }

    public Course(String courseID, String courseName, String instructor){
		super();
    	this.courseID = courseID;
    	this.courseName = courseName;
    	this.instructor = instructor;
    }
	
    public void setID(String courseID){
    	this.courseID = courseID;
    }

    public String getID(){
    	return courseID;
    }

    public void setName(String courseName){
    	this.courseName = courseName;
    }

    public String getName(){
    	return courseName;
    }

    public void setInstructor(String instructor){
    	this.instructor = instructor;
    }

    public String getInstructor(){
    	return instructor;
    }

}
