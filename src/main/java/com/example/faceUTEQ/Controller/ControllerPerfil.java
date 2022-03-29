/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Models.Perfil;
import com.example.faceUTEQ.Service.IPerfilServiceImp;
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
public class ControllerPerfil {
    
     @RequestMapping("perfil/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Perfil");
        return "index";
    }

    @Autowired
    private IPerfilServiceImp iPerfilService;

   // @Autowired
   // private ICategoriaService categoriaService;
    

    @GetMapping("index/perfil/")
    public String listaPerfil(Model model) {
        List<Perfil> perfil = iPerfilService.listarPerfil();
        model.addAttribute("perfil", perfil);
        return "index/perfil";
    }

    @GetMapping("index/agregarPerfil/")
    public String agregarPerfilPage(Perfil perfil, Model model) {
    //    List<Categoria> categoria = categoriaService.listarCategoria();
    //    model.addAttribute("categoria2", categoria);
        return "index/agregarPerfil";
    }

    @PostMapping("index/agregarPerfil/")
    public String agregarPerfil(@Valid Perfil perfil, Errors error,Model model) {
        if (error.hasErrors()) {
         //   List<Categoria> categoria = categoriaService.listarCategoria();
          //  model.addAttribute("categoria2", categoria);
            return "index/agregarPerfil";
        }
        iPerfilService.guardar(perfil);
        return "redirect:/index/perfil/";
    }

    @GetMapping("/index/editarPerfil/{id_prod}")
    public String editarPerfil(Perfil perfil, Model model) {
        perfil = iPerfilService.encontrarPerfil(perfil);
        model.addAttribute("perfil", perfil);
        
      //  List<Categoria> categoria = categoriaService.listarCategoria();
      //  model.addAttribute("categoria", categoria);
        return "index/modificarPerfil";
    }

    @GetMapping("index/borrar/{idPerfil}")
    public String borrarPerfil(Perfil perfil) {
        iPerfilService.eliminar(perfil);
        return "index/table-datatable";
    }
    
}
