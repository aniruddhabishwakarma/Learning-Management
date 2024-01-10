package com.LMS.Learning.Management.controllers;

import com.LMS.Learning.Management.models.admin.Admin;
import com.LMS.Learning.Management.models.admin.ResponseMessage;
import com.LMS.Learning.Management.services.adminservices.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminServices adminServices;

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminData(@PathVariable("id") long id){
        return adminServices.getAdminData(id);
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerAdmin(@RequestBody Admin admin){
        System.out.println("Hello");
        return adminServices.registerAdmin(admin);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseMessage> updateAdmin(@RequestBody Admin admin){
        return adminServices.updateAdmin(admin);
    }

    @PutMapping("/password")
    public ResponseEntity<ResponseMessage> updatePassword(@RequestBody Admin admin){
        return adminServices.updatePassword(admin);
    }
}
