package com.LMS.Learning.Management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
@Builder
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "course_title")
    private String courseTitle;
    @Column(name="course_description")
    private String courseDescription;
    @Column(name = "price")
    private int price;
    @Column(name="thumbnail")
    private String thumbnail;

}
