/**
 * 
 */
package com.crs.flipkart.business;

import java.util.ArrayList;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.exceptions.CourseNotFoundException;

/**
 * @author HP
 *
 */
public interface CourseInterface {
	public void removeCourse(int courseId) throws CourseNotFoundException;
    public void addCourse(Course course);
    public void updateCourse(Course course) throws CourseNotFoundException;
    public ArrayList<Course> getAllCourses();
    public Course getCourseFromCatalog(int courseId) throws CourseNotFoundException;
}
