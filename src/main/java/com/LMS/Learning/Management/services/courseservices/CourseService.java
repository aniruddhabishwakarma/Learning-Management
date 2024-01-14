package com.LMS.Learning.Management.services.courseservices;

import com.LMS.Learning.Management.models.courses.Course;
import com.LMS.Learning.Management.models.courses.CourseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CourseService {
    ResponseEntity<String> addCourse(Course course, MultipartFile file);

    ResponseEntity<List<CourseResponse>> displayCourses();

    ResponseEntity<?> returnPhoto(String fileName);
}
