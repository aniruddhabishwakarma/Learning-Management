package com.LMS.Learning.Management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "courses")
@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name= "course_title")
    private String courseTitle;
    @Column(name = "course_description")
    private String courseDescription;
    @Column(name = "photo")
    private String thumbnail;
    @Column(name = "price")
    private int price;
}
