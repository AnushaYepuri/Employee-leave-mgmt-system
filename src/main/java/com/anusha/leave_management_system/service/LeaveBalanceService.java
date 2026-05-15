package com.anusha.leave_management_system.service;

import com.anusha.leave_management_system.entity.LeaveBalance;
import com.anusha.leave_management_system.repository.LeaveBalanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaveBalanceService {

    private final LeaveBalanceRepository leaveBalanceRepository;

    // Constructor Injection
    public LeaveBalanceService(LeaveBalanceRepository leaveBalanceRepository) {
        this.leaveBalanceRepository = leaveBalanceRepository;
    }

    // Add Employee Leave Balance
    public LeaveBalance addEmployeeLeaveBalance(LeaveBalance leaveBalance) {
        return leaveBalanceRepository.save(leaveBalance);
    }

    // Get Leave Balance By Employee ID
    public Optional<LeaveBalance> getLeaveBalanceByEmployeeId(Long employeeId) {
        return leaveBalanceRepository.findByEmployeeId(employeeId);
    }

    // Add Leaves
    public LeaveBalance addLeaves(Long employeeId, int leavesToAdd) {

        LeaveBalance leaveBalance =
                leaveBalanceRepository.findByEmployeeId(employeeId).orElse(null);

        if (leaveBalance != null) {

            leaveBalance.setTotalLeaves(
                    leaveBalance.getTotalLeaves() + leavesToAdd
            );

            return leaveBalanceRepository.save(leaveBalance);
        }

        return null;
    }

    // Deduct Leaves
    public LeaveBalance deductLeaves(Long employeeId, int leavesToDeduct) {

        LeaveBalance leaveBalance =
                leaveBalanceRepository.findByEmployeeId(employeeId).orElse(null);

        if (leaveBalance != null) {

            leaveBalance.setUsedLeaves(
                    leaveBalance.getUsedLeaves() + leavesToDeduct
            );

            return leaveBalanceRepository.save(leaveBalance);
        }

        return null;
    }

    // Calculate Remaining Leaves
    public int calculateRemainingLeaves(Long employeeId) {

        LeaveBalance leaveBalance =
                leaveBalanceRepository.findByEmployeeId(employeeId).orElse(null);

        if (leaveBalance != null) {

            return leaveBalance.getTotalLeaves()
                    - leaveBalance.getUsedLeaves();
        }

        return 0;
    }

    // Update Leave Balance
    public LeaveBalance updateLeaveBalance(Long employeeId,
                                           LeaveBalance updatedLeaveBalance) {

        LeaveBalance existingLeaveBalance =
                leaveBalanceRepository.findByEmployeeId(employeeId).orElse(null);

        if (existingLeaveBalance != null) {

            existingLeaveBalance.setTotalLeaves(
                    updatedLeaveBalance.getTotalLeaves()
            );

            existingLeaveBalance.setUsedLeaves(
                    updatedLeaveBalance.getUsedLeaves()
            );

            return leaveBalanceRepository.save(existingLeaveBalance);
        }

        return null;
    }
}