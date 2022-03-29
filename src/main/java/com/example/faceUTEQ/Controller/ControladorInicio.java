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
         return "redirect:/estudiante/publicacion/";
    }

    @GetMapping("/comentarios")
    public String comentarios() {
        return "comentarios";
    }
//   @GetMapping("/admin")
//   public String Admin(Model modelo){
//        modelo.addAttribute("usuarios", IUsuarioService.listarUsuarios());
//        return "admin";
//   }

    @GetMapping("/admin")
    public String Admin() {
        return "comentarios";
    }

    @GetMapping("/estudiante")
    public String Estudiante() {
        return "comentarios";
    }

    @GetMapping("/profesor")
    public String Profesor() {
        return "auth-login";
    }

    @GetMapping("/login")
    public String Login() {
         return "auth-login";
    }
}
