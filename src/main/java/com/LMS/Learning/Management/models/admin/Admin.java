package com.LMS.Learning.Management.models.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Long id;
    private String fullname;
    private String username;
    private Long contact;
    private String password;
    private String newPassword;
}
