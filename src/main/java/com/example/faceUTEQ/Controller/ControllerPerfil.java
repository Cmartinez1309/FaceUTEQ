/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Dao.IUsuarioDao;
import com.example.faceUTEQ.Models.Perfil;
import com.example.faceUTEQ.Models.Usuario;
import com.example.faceUTEQ.Service.IPerfilServiceImp;
import com.example.faceUTEQ.Service.IUsuarioServiceImp;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private IUsuarioDao iUsuarioDao;

    // @Autowired
    // private ICategoriaService categoriaService;
    @GetMapping("index/perfil/")
    public String listaPerfil(Model model) {
        List<Perfil> perfil = iPerfilService.listarPerfil();
        model.addAttribute("perfil", perfil);
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

        return "perfil";
    }

    @GetMapping("index/agregarPerfil/")
    public String agregarPerfilPage(Perfil perfil, Model model) {
        //    List<Categoria> categoria = categoriaService.listarCategoria();
        //    model.addAttribute("categoria2", categoria);
        return "index/agregarPerfil";
    }

    @PostMapping("agregarPerfil/")
    public String agregarPerfil(@Valid Perfil perfil, Errors error, Model model, @RequestParam("img_perfil") MultipartFile imagen) {
        if (!imagen.isEmpty()) {
            Path direcionImagenes = Paths.get("src///web///images");
            String rutaAbsoluta = direcionImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                perfil.setImg_perfil(imagen.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String mensajae = "xd";

        iPerfilService.guardar(perfil);
        return mensajae;
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
