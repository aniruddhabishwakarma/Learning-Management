package com.LMS.Learning.Management.repositories;

import com.LMS.Learning.Management.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<CourseEntity,Long> {

}
