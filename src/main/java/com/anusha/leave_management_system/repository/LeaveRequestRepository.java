package com.anusha.leave_management_system.repository;

import com.anusha.leave_management_system.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
}