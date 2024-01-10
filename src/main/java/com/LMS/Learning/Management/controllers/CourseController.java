package com.LMS.Learning.Management.controllers;

import com.LMS.Learning.Management.models.admin.ResponseMessage;
import com.LMS.Learning.Management.models.courses.Course;
import com.LMS.Learning.Management.models.courses.CourseResponse;
import com.LMS.Learning.Management.services.courseservices.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/courses")
public class CourseController {

    @Autowired
    private ObjectMapper mapper;

    @Value("${project.image}")
    private String path;

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestParam("course") String data,
                                                    @RequestParam("file") MultipartFile file) throws IOException {
        Course course = mapper.readValue(data,Course.class);


        return courseService.addCourse(path,course,file);
    }
    @GetMapping
    public ResponseEntity<List<CourseResponse>> displayCourses(){
        return courseService.displayCourses();
    }




}
