package com.anusha.leave_management_system.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.anusha.leave_management_system.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int  id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @CreationTimestamp
    private LocalDateTime requestedAt;

   private String  leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private LeaveStatus status;
}
