/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Models.Amigos;
import com.example.faceUTEQ.Service.IAmigosServiceImp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author playe
 */
@Controller
public class ControllerAmigos {
    
    @RequestMapping("amigos/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Amigos");
        return "index";
    }

    @Autowired
    private IAmigosServiceImp iAmigosService;

   // @Autowired
   // private ICategoriaService categoriaService;
    

    @GetMapping("index/amigos/")
    public String listaAmigos(Model model) {
        List<Amigos> amigos = iAmigosService.listarAmigos();
        model.addAttribute("amigos", amigos);
        return "index/amigos";
    }

    @GetMapping("index/agregarAmigos/")
    public String agregarAmigosPage(Amigos amigos, Model model) {
     //   List<Categoria> categoria = categoriaService.listarCategoria();
       // model.addAttribute("categoria2", categoria);
        return "index/agregarAmigos";
    }

    @PostMapping("index/agregarAmigos/")
    public String agregarAmigos(@Valid Amigos amigos, Errors error,Model model) {
        if (error.hasErrors()) {
         //   List<Categoria> categoria = categoriaService.listarCategoria();
           // model.addAttribute("categoria2", categoria);
            return "index/agregarAmigos";
        }
        iAmigosService.guardar(amigos);
        return "redirect:/index/amigos/";
    }

    @GetMapping("/index/editarAmigos/{Id_amig}")
    public String editarAmigos(Amigos amigos, Model model) {
        amigos = iAmigosService.encontrarAmigos(amigos);
        model.addAttribute("amigos", amigos);
        
    //    List<Categoria> categoria = categoriaService.listarCategoria();
      //  model.addAttribute("categoria", categoria);
        return "index/modificarAmigos";
    }

    @GetMapping("index/borrar/{idAmigos}")
    public String borrarAmigos(Amigos amigos) {
        iAmigosService.eliminar(amigos);
        return "index/table-datatable";
    }
    
}
