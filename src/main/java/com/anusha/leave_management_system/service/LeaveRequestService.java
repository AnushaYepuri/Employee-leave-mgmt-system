package com.anusha.leave_management_system.service;

import com.anusha.leave_management_system.entity.LeaveBalance;
import com.anusha.leave_management_system.entity.LeaveRequest;
import com.anusha.leave_management_system.enums.LeaveStatus;
import com.anusha.leave_management_system.repository.LeaveBalanceRepository;
import com.anusha.leave_management_system.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveBalanceRepository leaveBalanceRepository;

    // Constructor Injection
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository,
                               LeaveBalanceRepository leaveBalanceRepository) {

        this.leaveRequestRepository = leaveRequestRepository;
        this.leaveBalanceRepository = leaveBalanceRepository;
    }

    // Apply Leave
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {

        leaveRequest.setStatus(LeaveStatus.PENDING);

        return leaveRequestRepository.save(leaveRequest);
    }

    // Approve Leave
    public LeaveRequest approveLeave(Long leaveRequestId) {

        LeaveRequest leaveRequest =
                leaveRequestRepository.findById(leaveRequestId).orElse(null);

        if (leaveRequest != null) {

            leaveRequest.setStatus(LeaveStatus.APPROVED);

            // Get employee leave balance
            LeaveBalance leaveBalance =
                    leaveBalanceRepository
                            .findByEmployeeId(
                                    leaveRequest.getEmployee().getId()
                            )
                            .orElse(null);

            if (leaveBalance != null) {

                int leaveDays = leaveRequest.getNumberOfDays();

                leaveBalance.setUsedLeaves(
                        leaveBalance.getUsedLeaves() + leaveDays
                );

                leaveBalanceRepository.save(leaveBalance);
            }

            return leaveRequestRepository.save(leaveRequest);
        }

        return null;
    }

    // Reject Leave
    public LeaveRequest rejectLeave(Long leaveRequestId) {

        LeaveRequest leaveRequest =
                leaveRequestRepository.findById(leaveRequestId).orElse(null);

        if (leaveRequest != null) {

            leaveRequest.setStatus(LeaveStatus.REJECTED);

            return leaveRequestRepository.save(leaveRequest);
        }

        return null;
    }

    // Get Leave By ID
    public LeaveRequest getLeaveById(Long leaveRequestId) {

        return leaveRequestRepository.findById(leaveRequestId).orElse(null);
    }

    // Get All Leave Requests
    public List<LeaveRequest> getAllLeaveRequests() {

        return leaveRequestRepository.findAll();
    }

    // Get Leaves By Employee
    public List<LeaveRequest> getLeavesByEmployee(Long employeeId) {

        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    // Get Leaves By Status
    public List<LeaveRequest> getLeavesByStatus(LeaveStatus status) {

        return leaveRequestRepository.findByStatus(status);
    }
}