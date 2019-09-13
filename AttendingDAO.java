package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendingDAO {
	
	private List<Attending> attendingList = new ArrayList<Attending>();

	//read the information about classes students registered for from the file
    public List<Attending> getAttending(){

    	try {
			String location = "src/attending.csv";
			File file = new File(location);
			Scanner input = new Scanner (file);
			
			while(input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				attendingList.add(new Attending(line[0], line[1]));
			} 
			input.close();
			
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		return attendingList;
    }

    //register student to a selected course
    public void registerStudentToCourse(List<Attending> attending, String studentEmail, String courseID){
    	
    	boolean notAttending = true;
    	
    	for (Attending a: attending) {
    		if ((a.getStudentEmail().equals(studentEmail)) && (a.getCourseID().equals(courseID))) {
    			System.out.println("Student already registered for this course!");
    			notAttending = false;
    		}
    	}
    	if (notAttending) {
    		Attending newAttending = new Attending(courseID, studentEmail);
    		attending.add(newAttending);
    		
    		saveAttending(attending);
    		System.out.println("Course has been added!");
    	}
    }

    //get the information about all the courses a specific student registered for
    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
	
    	List<Course> studentCourseList = new ArrayList<Course>();
    	
    	for (Attending a : attending) {
    		if (studentEmail.equals(a.getStudentEmail())) {  
    			
    			for (Course course: courseList) {
    				if (course.getID().equals(a.getCourseID())) {
   
    					studentCourseList.add(course);
    				}
    			}
    		}
    	}
    	return studentCourseList;
    }

    //save new registration information to the file
    public void saveAttending(List<Attending> attending){
    	 	
		try {
			String location = "src/attending.csv";
			File file = new File(location);
			
			FileWriter writer = new FileWriter(file, false);
			for (Attending a: attending) {
	            writer.write(a.getCourseID() + "," + a.getStudentEmail() + "\n");
	    	}
	    	writer.close();
	    	
		} catch (IOException e) {		
			System.out.println("File not found!");
		}
    }

}

