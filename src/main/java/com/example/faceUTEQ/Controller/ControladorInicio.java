/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;
;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {

    @GetMapping("/")
    public String page() {
        return "auth-login";
    }

    @GetMapping("/login")
    public String IniciarSesion() {
        return "auth-login";
    }

//   @GetMapping("/admin")
//   public String Admin(Model modelo){
//        modelo.addAttribute("usuarios", IUsuarioService.listarUsuarios());
//        return "admin";
//   }
}
