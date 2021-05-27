package com.example.mybatisexamples.example05;

import com.example.mybatisexamples.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO05 {
    private Long id;
    private String name;
    private String company;
    private List<Address> addressList;
}
