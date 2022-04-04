/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Dao.IAmigosDao;
import com.example.faceUTEQ.Dao.IUsuarioDao;
import com.example.faceUTEQ.Models.Amigos;
import com.example.faceUTEQ.Models.Usuario;
import com.example.faceUTEQ.Service.IAmigosServiceImp;
import com.example.faceUTEQ.Service.UsuarioService1;
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
public class ControllerAmigos {

    @RequestMapping("amigos/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Amigos");
        return "index";
    }

    @Autowired
    private IAmigosServiceImp iAmigosService;
    @Autowired
    private IUsuarioDao iUsuarioDao;
    @Autowired
    private IAmigosDao amigosDao;
    @Autowired
    private UsuarioService1 service1;
    // @Autowired
    // private ICategoriaService categoriaService;

    @GetMapping("index/amigos/")
    public String listaAmigos(Model model) {
        List<Amigos> amigos = iAmigosService.listarAmigos();
        List<Usuario> usuariosv2 = service1.listarUsuario();
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
        model.addAttribute("usuariosv2", usuariosv2);
        model.addAttribute("amigos", amigos);
        return "amigos";
    }

    @GetMapping("index/agregarAmigos/xd")
    public String agregarAmigosPage(Amigos amigos, Model model) {
        //   List<Categoria> categoria = categoriaService.listarCategoria();
        // model.addAttribute("categoria2", categoria);
        return "index/agregarAmigos";
    }

    @PostMapping("index/agregarAmigos/")
    public String agregarAmigos(Amigos amigos, Model model) {
        amigosDao.updateUserNameById(amigos.getEstatus(), amigos.getId_amig());
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

    @PostMapping("index/agregarSolicituudv2/")
    public String agregarAmigosv2(Amigos amigos, Model model) {
        iAmigosService.guardar(amigos);
        return "redirect:/index/amigos/";
    }
}
