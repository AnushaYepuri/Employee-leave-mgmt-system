package com.anusha.leave_management_system.controller;



import com.anusha.leave_management_system.entity.LeaveRequest;
import com.anusha.leave_management_system.enums.LeaveStatus;
import com.anusha.leave_management_system.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    // Constructor Injection
    public LeaveRequestController(
            LeaveRequestService leaveRequestService) {

        this.leaveRequestService = leaveRequestService;
    }

    // Apply Leave
    @PostMapping
    public LeaveRequest applyLeave(
            @RequestBody LeaveRequest leaveRequest) {

        return leaveRequestService.applyLeave(leaveRequest);
    }

    // Approve Leave
    @PutMapping("/approve/{id}")
    public LeaveRequest approveLeave(@PathVariable Long id) {

        return leaveRequestService.approveLeave(id);
    }

    // Reject Leave
    @PutMapping("/reject/{id}")
    public LeaveRequest rejectLeave(@PathVariable Long id) {

        return leaveRequestService.rejectLeave(id);
    }

    // Get Leave By ID
    @GetMapping("/{id}")
    public LeaveRequest getLeaveById(@PathVariable Long id) {

        return leaveRequestService.getLeaveById(id);
    }

    // Get All Leave Requests
    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {

        return leaveRequestService.getAllLeaveRequests();
    }

    // Get Leaves By Employee
    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeavesByEmployee(
            @PathVariable Long employeeId) {

        return leaveRequestService
                .getLeavesByEmployee(employeeId);
    }

    // Get Leaves By Status
    @GetMapping("/status/{status}")
    public List<LeaveRequest> getLeavesByStatus(
            @PathVariable LeaveStatus status) {

        return leaveRequestService.getLeavesByStatus(status);
    }
}