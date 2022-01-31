/**
 * 
 */
package com.crs.flipkart.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.StudentRegisteredCourses;
import com.crs.flipkart.business.StudentImplementation;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.constants.Gender;
import com.crs.flipkart.constants.Role;
import com.crs.flipkart.dao.CourseDaoImplementation;
import com.crs.flipkart.dao.CourseDaoInterface;
import com.crs.flipkart.dao.StudentDaoInterface;
import com.crs.flipkart.dao.StudentDaoOperation;


/**
 * @author Rama
 *
 */

@Path("/StudentApi")
public class StudentRestApi {
	
	
	//private StudentImplementation studentImplementation = new StudentImplementation();
	@GET
	@Path("/viewStudents/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Student viewStudent(@PathParam("studentId") int studentId){
		
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
		Student student = new Student();
//		student.setStudentId(3);
//		student.setContactNo("1234");
//		student.setAddress("AP");
//		student.setGender(Gender.MALE);
//		student.setGradeCardVisibility(true);
//		student.setPasswordHash("123");
//		student.setRole(Role.STUDENT);
//		student.setUserId(3);
//		student.setUsername("Vivek");
//		student.setName("Vivek");
		try {
			student = studentDaoOperation.viewStudentDetails(studentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudentData(Student student) {
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
		studentDaoOperation.addStudentData(student);//convert business class function to boolean return type
		
	   return Response.status(201).entity("student is succesfully added "+student).build();
		
	} 
	
	
	
	@GET
	@Path("/catalogue")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseCatalogue() {
		System.out.println("before");
		//StudentImplementation studentImplementation = StudentImplementation.getInstance(); //error is here..
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
		System.out.println("after");
       ArrayList<Course> result = studentDaoOperation.viewAllCourses();
       System.out.print(result);
       return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/paymentStatus/{studentId}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response paymentStatus(@PathParam("studentId") int studentId) {
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
       String result = studentDaoOperation.getPaymentStatus(studentId);
       return Response.status(Status.OK).entity(result).build();
	}
	
	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewStudentData() {
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
       ArrayList<Student> result = studentDaoOperation.viewAllStudents();
       System.out.print(result);
       return Response.status(Status.OK).entity(result).build();
	}
	
	
	@GET
	@Path("/studentRegistered/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response studentAlreadyRegistered(@PathParam("studentId") int studentId) {
		StudentDaoInterface studentDaoOperation = new StudentDaoOperation();
       Boolean result = studentDaoOperation.studentAlreadyRegistered(studentId);
       System.out.print(result);
       return Response.status(Status.OK).entity(result).build();
	}
	
	@GET
	@Path("/gradecard/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayGradeCard(@PathParam("studentId") int studentId) {
		CourseDaoInterface courseDaoImplementation = CourseDaoImplementation.getInstance();
		StudentRegisteredCourses studentRegisteredCourses = courseDaoImplementation.getStudentRegisteredCourses(studentId);
       return Response.status(Status.OK).entity(studentRegisteredCourses).build();
	}
	
	@GET
	@Path("/")
	public String hello() {
		//return Response.status(Status.OK).entity("hello").build();
		System.out.println("hello");
		return "hello";
	}
	
}
