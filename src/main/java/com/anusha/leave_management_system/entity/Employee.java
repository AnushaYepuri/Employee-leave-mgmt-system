package com.anusha.leave_management_system.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    private String name;
    private String email;
    private String department;
    private String project;
    private String role;

}
