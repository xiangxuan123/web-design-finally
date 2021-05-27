package com.example.springmvc.experiment08;

import com.example.springmvc.experiment08.component.EncryptorComponent;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityConfiguration {
    @Autowired
    private EncryptorComponent encryptorComponent;

}
