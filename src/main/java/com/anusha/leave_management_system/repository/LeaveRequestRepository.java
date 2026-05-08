package com.anusha.leave_management_system.repository;

import com.anusha.leave_management_system.entity.LeaveRequest;
import com.anusha.leave_management_system.enums.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    List<LeaveRequest> findByEmployeeId(Long employeeId);

    List<LeaveRequest> findByStatus(LeaveStatus status);

    List<LeaveRequest> findByEmployeeIdAndStatus(Long employeeId, LeaveStatus status);

}