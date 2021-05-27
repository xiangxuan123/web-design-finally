package com.example.springmvc.example06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User06 {
    private Long id;
    private String userName;
    private String password;
    private String role;
}
