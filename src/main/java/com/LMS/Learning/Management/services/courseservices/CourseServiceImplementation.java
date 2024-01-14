package com.LMS.Learning.Management.services.courseservices;

import com.LMS.Learning.Management.CustomMessage;
import com.LMS.Learning.Management.entities.CourseEntity;
import com.LMS.Learning.Management.models.courses.Course;
import com.LMS.Learning.Management.models.courses.CourseResponse;
import com.LMS.Learning.Management.repositories.CoursesRepository;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Value("${project.image}")
    private String path;
    @Override
    public ResponseEntity<String> addCourse(Course course, MultipartFile file) {

        try{
            String fileName = file.getOriginalFilename();
            String filePath = path + File.separator+fileName;


            File f = new File(path);
            if(!f.exists()){
                f.mkdir();
            }

            Files.copy(file.getInputStream(), Paths.get(filePath));

            CourseEntity courseEntity =CourseEntity.builder().
                    courseTitle(course.getCourseTitle())
                    .courseDescription(course.getCourseDescription())
                    .price(course.getPrice())
                    .thumbnail("/admin/courses/photo?fileName="+fileName)
                    .build();

            coursesRepository.save(courseEntity);
            return new ResponseEntity<>("Course added successfully", HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<List<CourseResponse>> displayCourses() {
        List<CourseEntity> courseEntity = coursesRepository.findAll();
        List<CourseResponse>  courseList = courseEntity.stream()
                .map(courseData -> {
                    CourseResponse courseResponse = new CourseResponse();
                    BeanUtils.copyProperties(courseData,courseResponse);
                    return courseResponse;
                }).collect(Collectors.toList());


        return new ResponseEntity<>(courseList,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> returnPhoto(String fileName) {
        String filePath = path + File.separator+fileName;
        try{
           InputStream inputStream = new FileInputStream(filePath);
            byte[] out = IOUtils.toByteArray(inputStream);
            HttpHeaders responseHeaders=new HttpHeaders();
            responseHeaders.set("charset","utf-8");
            responseHeaders.setContentType(MediaType.IMAGE_JPEG);
            return  new ResponseEntity<>(out,responseHeaders,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(CustomMessage.builder().message(e.getMessage()));
        }
    }
}
