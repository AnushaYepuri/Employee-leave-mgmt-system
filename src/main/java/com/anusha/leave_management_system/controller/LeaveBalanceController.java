package com.anusha.leave_management_system.controller;



import com.anusha.leave_management_system.entity.LeaveBalance;
import com.anusha.leave_management_system.service.LeaveBalanceService;
import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

@RestController
@RequestMapping("/leave-balance")
public class LeaveBalanceController {

    private final LeaveBalanceService leaveBalanceService;

    // Constructor Injection
    public LeaveBalanceController(LeaveBalanceService leaveBalanceService) {
        this.leaveBalanceService = leaveBalanceService;
    }

    // Add Leave Balance
    @PostMapping
    public LeaveBalance addLeaveBalance(
            @RequestBody LeaveBalance leaveBalance) {

        return leaveBalanceService
                .addEmployeeLeaveBalance(leaveBalance);
    }

    // Get Leave Balance By Employee ID
    @GetMapping("/{employeeId}")
    public Optional<LeaveBalance> getLeaveBalance(
            @PathVariable Long employeeId) {

        return leaveBalanceService
                .getLeaveBalanceByEmployeeId(employeeId);
    }

    // Add Leaves
    @PutMapping("/add/{employeeId}")
    public LeaveBalance addLeaves(@PathVariable Long employeeId,
                                  @RequestParam int leaves) {

        return leaveBalanceService.addLeaves(employeeId, leaves);
    }

    // Deduct Leaves
    @PutMapping("/deduct/{employeeId}")
    public LeaveBalance deductLeaves(@PathVariable Long employeeId,
                                     @RequestParam int leaves) {

        return leaveBalanceService.deductLeaves(employeeId, leaves);
    }

    // Calculate Remaining Leaves
    @GetMapping("/remaining/{employeeId}")
    public int getRemainingLeaves(@PathVariable Long employeeId) {

        return leaveBalanceService
                .calculateRemainingLeaves(employeeId);
    }
}