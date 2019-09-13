package CoreJava.Models;

public class Student {
	
	private String email;
	private String name;
	private String pass;
	
    public Student(){
    }
	
    public Student(String email, String name, String pass){
		super();
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public void setEmail(String email){
    	this.email = email;
    }

    public String getEmail(){
    	return email;
    }
    
    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setPass(String pass){
    	this.pass = pass;
    }

    public String getPass(){
    	return pass;
    }
}

