/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Dao.IUsuarioDao;
import com.example.faceUTEQ.Models.Comentarios;
import com.example.faceUTEQ.Models.Publicacion;
import com.example.faceUTEQ.Models.Usuario;
import com.example.faceUTEQ.Service.IAmigosServiceImp;
import com.example.faceUTEQ.Service.IComentariosServiceImp;
import com.example.faceUTEQ.Service.IPublicacionServiceImp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class ControllerPublicacion {

    @Autowired
    private IPublicacionServiceImp iPublicacionService;
    @Autowired
    private IComentariosServiceImp comentariosServiceImp;
    @Autowired
    private IUsuarioDao iUsuarioDao;

    // @Autowired
    // private ICategoriaService categoriaService;
    @GetMapping("/estudiante/publicacion/")
    public String listaPublicacion(Model model) {
        List<Publicacion> publicacion = iPublicacionService.listarPublicacion();
        List<Comentarios> comentarios = comentariosServiceImp.listarComentarios();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            List<Usuario> usuarios = iUsuarioDao.findByCorreo(username);
            model.addAttribute("usuarios", usuarios);
        } else {
            String username = principal.toString();
            List<Usuario> usuarios = iUsuarioDao.findByCorreo(username);
            model.addAttribute("usuarios", usuarios);
        }
        model.addAttribute("Publicacion", publicacion);
        model.addAttribute("Comentarios", comentarios);
        return "comentarios";
    }

    @GetMapping("/index/agregarPublicacion/")
    public String agregarPublicacionPage(Publicacion publicacion, Model model) {
        //  List<Categoria> categoria = categoriaService.listarCategoria();
        //  model.addAttribute("categoria2", categoria);
        return "index/agregarPublicacion";
    }

    @PostMapping("index/agregarPublicacion/")
    public String agregarPublicacion(@Valid Publicacion publicacion, Errors error, Model model) {
        if (error.hasErrors()) {
            //  List<Categoria> categoria = categoriaService.listarCategoria();
            //  model.addAttribute("categoria2", categoria);
            return "index/agregarPublicacion";
        }
        iPublicacionService.guardar(publicacion);
        return "redirect:/index/publicacion/";
    }

    @GetMapping("/index/editarPublicacion/{Id_pb}")
    public String editarPublicacion(Publicacion publicacion, Model model) {
        publicacion = iPublicacionService.encontrarPublicacion(publicacion);
        model.addAttribute("publicacion", publicacion);

        //  List<Categoria> categoria = categoriaService.listarCategoria();
        //   model.addAttribute("categoria", categoria);
        return "index/modificarPublicacion";
    }

    @GetMapping("index/borrar/{idPublicacion}")
    public String borrarPublicacion(Publicacion publicacion) {
        iPublicacionService.eliminar(publicacion);
        return "index/table-datatable";
    }

    @RequestMapping("estudiante/")
    public String estudiante(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Publicacion");
        return "auth-login";
    }
}
