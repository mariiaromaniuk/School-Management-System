package CoreJava.DAO;

import CoreJava.Models.Course;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseDAO {
	
	static List<Course> courseList = new ArrayList<Course>();
	
	//read the information about all the existing courses from the file
    public List<Course> getAllCourses(){
    	try {
			String location = "src/courses.csv";
			File file = new File(location);
			Scanner input = new Scanner (file);
			
			while(input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				courseList.add(new Course(line[0], line[1], line[2]));
			} 
			input.close();
			
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		return courseList;
    }
}
