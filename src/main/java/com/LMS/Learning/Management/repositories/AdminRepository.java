package com.LMS.Learning.Management.repositories;

import com.LMS.Learning.Management.entities.AdminData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminData,Long> {
}
