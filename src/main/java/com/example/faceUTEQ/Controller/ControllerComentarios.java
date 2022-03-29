/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Models.Comentarios;
import com.example.faceUTEQ.Service.IComentariosServiceImp;
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
public class ControllerComentarios {
    
     @RequestMapping("comentarios/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Comentarios");
        return "index";
    }

    @Autowired
    private IComentariosServiceImp iComentariosService;

    //@Autowired
    //private ICategoriaService categoriaService;
    

    @GetMapping("index/comentarios/")
    public String listaComentarios(Model model) {
        List<Comentarios> comentarios = iComentariosService.listarComentarios();
        model.addAttribute("comentarios", comentarios);
        return "index/comentarios";
    }

    @GetMapping("index/agregarComentarios/")
    public String agregarComentariosPage(Comentarios comentarios, Model model) {
       // List<Categoria> categoria = categoriaService.listarCategoria();
       // model.addAttribute("categoria2", categoria);
        return "index/agregarComentarios";
    }

    @PostMapping("index/agregarComentarios/")
    public String agregarComentarios(@Valid Comentarios comentarios, Errors error,Model model) {
        if (error.hasErrors()) {
          //  List<Categoria> categoria = categoriaService.listarCategoria();
          //  model.addAttribute("categoria2", categoria);
            return "index/agregarComentarios";
        }
        iComentariosService.guardar(comentarios);
        return "redirect:/index/comentarios/";
    }

    @GetMapping("/index/editarComentarios/{Id_cmt}")
    public String editarComentarios(Comentarios comentarios, Model model) {
        comentarios = iComentariosService.encontrarComentarios(comentarios);
        model.addAttribute("comentarios", comentarios);
        
      //  List<Categoria> categoria = categoriaService.listarCategoria();
      //  model.addAttribute("categoria", categoria);
        return "index/modificarComentarios";
    }

    @GetMapping("index/borrar/{idComentarios}")
    public String borrarComentarios(Comentarios comentarios) {
        iComentariosService.eliminar(comentarios);
        return "index/table-datatable";
    }
    
}
