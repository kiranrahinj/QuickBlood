package com.QuickBlood.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NotNull
    @NotBlank(message = "Name should not be empty")
    private String name;
    @NotBlank(message = "blood group should not be empty")
    @NotNull
    @Column(nullable = false)
    private String bloodType;
    @Column(nullable = false)
    @NotNull
    @NotBlank(message = "Location should not be empty")
    private String location;
    @Column(nullable = false)
    @NotNull
    @NotBlank(message = "Mobile Number should not be empty")
    private String mobileNumber;
    @Column(nullable = false)
    @NotNull
    @NotBlank(message = "email should not be empty")
    private String email;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
