
package com.example.faceUTEQ.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        String password = "123";
        System.out.println("pwd:" + password);
        System.out.println("pwd encriptado:" + encriptarPassword(password));
        
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
