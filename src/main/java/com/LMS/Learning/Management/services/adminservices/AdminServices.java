package com.LMS.Learning.Management.services.adminservices;

import com.LMS.Learning.Management.models.admin.Admin;
import com.LMS.Learning.Management.models.admin.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminServices {
    ResponseEntity<ResponseMessage> registerAdmin(Admin admin);

    ResponseEntity<Admin> getAdminData(Long id);

    ResponseEntity<ResponseMessage> updateAdmin(Admin admin);

    ResponseEntity<ResponseMessage> updatePassword(Admin admin);
}
