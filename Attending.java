package CoreJava.Models;

public class Attending {
	
	private String courseID;
	private String studentEmail;
	
    public Attending(){
    }

    public Attending(String courseID, String studentEmail){
		super();
    	this.courseID = courseID;
    	this.studentEmail = studentEmail;
    }

    public void setCourseID(String courseID){
    	this.courseID = courseID;
    }

    public String getCourseID(){
    	return courseID;
    }

    public void setStudentEmail(String studentEmail){
    	this.studentEmail = studentEmail;
    }

    public String getStudentEmail(){
    	return studentEmail;
    }
}
