package com.anusha.leave_management_system.repository;

import com.anusha.leave_management_system.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {

}