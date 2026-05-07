package com.anusha.leave_management_system.entity;

import java.time.LocalDateTime;
import java.util.Date;
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
   private Date startDate;
   private Date endDate;
  private int   status; //(PENDING / APPROVED / REJECTED)
}
