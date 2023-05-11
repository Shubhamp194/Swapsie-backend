package com.shubham.swapsie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String roles;
    private long id;
    private String fname;
    private String lName;
    private String email;
}
