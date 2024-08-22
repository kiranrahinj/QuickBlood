package com.QuickBlood.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String name;

    private String bloodType;

    private String location;

    private String mobileNumber;

    private String email;
}
