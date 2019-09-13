package CoreJava.DAO;

import CoreJava.Models.Student;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	//read the information about students from the file
    public List<Student> getStudents(){
    	
    	try {
			String location = "src/students.csv";
			File file = new File(location);
			Scanner input = new Scanner (file);
			
			while(input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				studentList.add(new Student(line[0], line[1], line[2]));
			} 
			input.close();
			
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		return studentList;
    }
 
    //get the information about student by provided email
    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	
    	Student lookup = null;
    	for (Student student: studentList) {
    		if (studentEmail.equals(student.getEmail())) {
				lookup = student;
            }
    	}
    	return lookup;
    }

    //validate the information provided by the student
    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	
    	for (Student student: studentList) {
    		if (studentEmail.equals(student.getEmail()) && studentPass.equals(student.getPass())) 
                System.out.println("Login Successful!\n");
                return true;
    	}
    	return false;
    }
}

