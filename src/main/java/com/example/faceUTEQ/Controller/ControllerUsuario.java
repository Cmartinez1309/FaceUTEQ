/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;
import com.example.faceUTEQ.Models.Usuario;
import com.example.faceUTEQ.Service.IUsuarioServiceImp;
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
public class ControllerUsuario {
    
     @RequestMapping("usuario/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Usuario");
        return "index";
    }

    @Autowired
    private IUsuarioServiceImp iUsuarioService;

   // @Autowired
   // private ICategoriaService categoriaService;
    

    @GetMapping("index/usuario/")
    public String listaUsuario(Model model) {
        List<Usuario> usuario = iUsuarioService.listarUsuario();
        model.addAttribute("usuario", usuario);
        return "index/usuario";
    }

    @GetMapping("index/agregarUsuario/")
    public String agregarUsuarioPage(Usuario usuario, Model model) {
      //  List<Categoria> categoria = categoriaService.listarCategoria();
     //   model.addAttribute("categoria2", categoria);
        return "index/agregarUsuario";
    }

    @PostMapping("index/agregarUsuario/")
    public String agregarUsuario(@Valid Usuario usuario, Errors error,Model model) {
        if (error.hasErrors()) {
          //  List<Categoria> categoria = categoriaService.listarCategoria();
           // model.addAttribute("categoria2", categoria);
            return "index/agregarUsuario";
        }
        iUsuarioService.guardar(usuario);
        return "redirect:/index/usuario/";
    }

    @GetMapping("/index/editarUsuario/{Id_usu}")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = iUsuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        
      //  List<Categoria> categoria = categoriaService.listarCategoria();
       // model.addAttribute("categoria", categoria);
        return "index/modificarUsuario";
    }

    @GetMapping("index/borrar/{idUsuario}")
    public String borrarUsuario(Usuario usuario) {
        iUsuarioService.eliminar(usuario);
        return "index/table-datatable";
    }
    
}
