package com.LMS.Learning.Management.models.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Long id;
    private String courseTitle;
    private String courseDescription;
    private int price;


}
