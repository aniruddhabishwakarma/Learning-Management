package com.LMS.Learning.Management.services.adminservices;

import com.LMS.Learning.Management.entities.AdminData;
import com.LMS.Learning.Management.models.admin.Admin;
import com.LMS.Learning.Management.models.admin.ResponseMessage;
import com.LMS.Learning.Management.repositories.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesImplementation implements AdminServices {

    @Autowired
    AdminRepository adminRepository;
    @Override
    public ResponseEntity<ResponseMessage> registerAdmin(Admin admin) {
        AdminData adminData = AdminData.builder()
                            .fullname(admin.getFullname())
                            .username(admin.getUsername())
                            .contact(admin.getContact())
                            .password(admin.getPassword())
                            .build();

        adminRepository.save(adminData);
        return new ResponseEntity<>(new ResponseMessage("User registered succesfully"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Admin> getAdminData(Long id) {
//        List<AdminData> adminDataList =adminRepository.findAll();
//        List<Admin> adminList = adminDataList.stream()
//                .map(adminData -> {
//                    Admin admin = new Admin();
//                    BeanUtils.copyProperties(adminData,admin);
//                    return admin;
//                }).collect(Collectors.toList());
//        return new ResponseEntity<>(adminList,HttpStatus.OK);
        AdminData adminData = adminRepository.findById(id).get();
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminData,admin);
        return new ResponseEntity<>(admin,HttpStatus.OK);



    }

    @Override
    public ResponseEntity<ResponseMessage> updateAdmin(Admin admin) {
        AdminData adminData = adminRepository.findById(admin.getId()).get();
        adminData.setFullname(admin.getFullname());
        adminData.setUsername(admin.getUsername());
        adminData.setContact(admin.getContact());
        adminRepository.save(adminData);
        return new ResponseEntity<>(new ResponseMessage("Successfully Updated"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseMessage> updatePassword(Admin admin) {
        AdminData adminData = adminRepository.findById(admin.getId()).get();
        if(!admin.getPassword().equals(adminData.getPassword())){
            return new ResponseEntity<>(new ResponseMessage("Your current password does not match"),HttpStatus.FORBIDDEN);
        }else{
            adminData.setPassword(admin.getNewPassword());
            adminRepository.save(adminData);
            return new ResponseEntity<>(new ResponseMessage("Password has been updated succesfully"),HttpStatus.OK);
        }
    }
}
