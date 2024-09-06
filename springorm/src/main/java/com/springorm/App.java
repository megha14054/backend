package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//        Student student=new Student(1232,"Hitesh","Lucknow");
//       int r= studentDao.insert(student);
//       System.out.println("Done "+r);
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go)
        {
        	System.out.println("Press 1 for adding new student");
            System.out.println("Press 2 for display all student");
            System.out.println("Press 3 for get detail of single object");
            System.out.println("Press 4 for delete students");
            System.out.println("Press 5 for update students");
            System.out.println("Press 6 for exit");
            
            try {
            	
            	int input=Integer.parseInt(br.readLine());
            	switch(input)
            	{
            	case 1:
            		//add
            		System.out.println("Enter user id: ");
            		int uId=Integer.parseInt(br.readLine());
            		
            		System.out.println("Enter user name: ");
            		String uName=br.readLine();
            		
            		System.out.println("Enter user city: ");
            		String uCity=br.readLine();
            		
            		Student s=new Student();
            		s.setStudentId(uId);
            		s.setStudentName(uName);
            		s.setStudentCity(uCity);
            		
            		int r=studentDao.insert(s);
            		System.out.println(r +"student added");
            		System.out.println("-------------------------");
            		break;
            		
            	case 2:
            		//display
            		
            		List<Student> allStudents=studentDao.getAllStudents();
            		for(Student st:allStudents)
            		{
            			System.out.println("Id:"+st.getStudentId()+" Name:"+st.getStudentName()+" city:"+st.getStudentCity());
            			System.out.println("-------------------------");
            			
            		}
            		
            		break;
            	case 3:
            		//get detail of single object
            		System.out.println("Enter student id");
            		int userId=Integer.parseInt(br.readLine());
            		Student student=studentDao.getStudent(userId);
            		System.out.println("Id:"+student.getStudentId());
            		System.out.println("name:" +student.getStudentName());
            		System.out.println("City:"+student.getStudentCity());
            		System.out.println("-------------------------");
            		
            		break;
            		
            	case 4:
            		//delete
            		System.out.println("Enter studentid to be deleted");
            		int u=Integer.parseInt(br.readLine());
            		try {
            			studentDao.deleteStudent(u);
                		System.out.println("Item deleted");	
            		}
            		catch(Exception e)
            		{
            			System.out.println("No such id exist");
            			System.out.println(e.getMessage());
            		}
            		
            		
            		
            		break;
            		
            	case 5:
            		//update
            		break;
            		
            	case 6:
            		
            		//exit
            		go=false;
            		break;
            		
            	
            	}
            	 
            }
            catch(Exception e)
            {
            	System.out.println("Invalid input");
            	System.out.println(e.getMessage());
            }
        }
        
        
    }
}
