package com.QuickBlood.DTO;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "Name should not be empty")
    @NotNull
    private String name;
    @NotBlank(message = "Blood Group should not be empty")
    @NotNull
    private String bloodType;
    @NotBlank(message = "Location should not be empty")
    @NotNull
    private String location;
    @Column(unique = true)
    @NotBlank(message = "Mobile Number should not be empty")
    @NotNull
    private String mobileNumber;
    @Column(unique = true)
    @NotNull
    @NotBlank(message = "Email should not be empty")
    private String email;
}
