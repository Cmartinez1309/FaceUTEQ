/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author usuario
 */
public class Inicio {

    @GetMapping("/")
    public String page() {
        return "index";
    }

    @GetMapping("/admin")
    public String Admin() {
        return "admin";
    }

    @GetMapping("/estudiante")
    public String Estudiante() {
        return "estudiante";
    }

    @GetMapping("/profesor")
    public String Profesor() {
        return "profesor";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }
}
