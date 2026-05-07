package com.anusha.leave_management_system.entity;
import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String leavetype;
    private int  totalLeaves;
    private int usedLeaves;
    private int remainingLeaves;
}
