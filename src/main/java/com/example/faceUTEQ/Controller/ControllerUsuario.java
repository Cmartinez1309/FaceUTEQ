/*

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
 /*
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
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Dao.IUsuarioDao;
import com.example.faceUTEQ.Models.Publicacion;
import com.example.faceUTEQ.Models.Usuario;
import com.example.faceUTEQ.Service.IUsuarioServiceImp;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

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
 * @author usuario
 */
@Controller
@Slf4j
public class ControllerUsuario {

//@GetMapping("/admin")
//    public String Usuario() {
//        return "admin/usuario";
//    }
//     @RequestMapping("admin/")
//    public String page(Model model) {
//        model.addAttribute("nombre", "Hola desde Controlador Usuario");
//        return "admin/usuario";
//    }
//   @RequestMapping("admin/")
//    public String page(Model model) {
//        model.addAttribute("nombre", "Hola desde Controlador Usuario");
//        return "index";
//    }
//    @GetMapping("/admin/usuario")
//    public String listaUsuario(Model model) {
//        List<Usuario> usuario = usuarioService.listarUsuario();
//        model.addAttribute("usuario", usuario);
//        return "admin/usuario";
//    }
//  @RequestMapping("admin/")
//    public String Usuario(Model model) {
//        model.addAttribute("nombre", "Hola desde Controlador Publicacion");
//       return "admin/usuario";
//    }
//@GetMapping("/admin")
//    public String listaUsuario(Model model) {
//        List<Usuario> usuario = usuarioService.listarUsuario();
//        model.addAttribute("usuario", usuario);
//        return "usuario";
//    }
//    @GetMapping("admin/agregarUsuario/")
//    public String agregarUsuarioPage(Usuario usuario) {
//        return "admin/modificarUsuario";
//    }
//
//    @PostMapping("admin/agregarUsuario/")
//    public String agregarUsuario(@Valid Usuario usuario, Errors error) {
//        if (error.hasErrors()) {
//            return "admin/modificarUsuario";
//        }
//        usuarioService.guardar(usuario);
//        return "redirect:/admin/usuario/";
//    }
//
//    @GetMapping("/admin/editarUsuario/{id_usu}")
//    public String editarUsuario(Usuario usuario, Model model) {
//        usuario = usuarioService.encontrarUsuario(usuario);
//        model.addAttribute("usuario", usuario);
//        return "admin/modificarUsuario";
//    }
//
//    @GetMapping("admin/borrar/{idUsuario}")
//    public String borrarUsuarios(Usuario usuario) {
//        usuarioService.eliminar(usuario);
//        return "admin/table-datatable";
//    }
    @RequestMapping("usuario/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Inicio");
        return "index";
    }

    @Autowired
    private IUsuarioServiceImp usuarioService;
    @Autowired
    private IUsuarioDao iUsuarioDao;
//    @Autowired
//    private ICategoriaService categoriaService;

    @GetMapping("admin/")
    public String listaProducto(Model model) {
        List<Usuario> usuario = usuarioService.listarUsuario();
        model.addAttribute("usuario", usuario);
        return "admin/usuario";
    }

    @GetMapping("admin/agregarUsuario/")
    public String agregarUsuarioPage(Usuario usuario, Model model) {
//        List<Categoria> categoria = categoriaService.listarCategoria();
//        model.addAttribute("categoria2", categoria);
        return "admin/agregarUsuario";
    }

    @PostMapping("admin/agregarUsuario/")
    public String agregarUsuario(@Valid Usuario usuario, Errors error, Model model) {
        if (error.hasErrors()) {
//            List<Categoria> categoria = categoriaService.listarCategoria();
//            model.addAttribute("categoria2", categoria);
            return "admin/agregarUsuario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/admin/usuario/";
    }

    @GetMapping("/admin/editarUsuario/{id_usu}")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);

//        List<Categoria> categoria = categoriaService.listarCategoria();
//        model.addAttribute("categoria", categoria);
        return "admin/modificarUsuario";
    }

    @GetMapping("admin/borrar/{idUsuario}")
    public String borrarUsuario(Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "admin/table-datatable";
    }

    @PostMapping("/recuperarContrasena/")
    public String busacurUsuario(Usuario usuario, Model model) {
        List<Usuario> usuarios = iUsuarioDao.findByCorreoAndNacionalidadAndNombre(usuario.getCorreo(), usuario.getNacionalidad(), usuario.getNombre());

        if (usuarios.size() >0) {
           model.addAttribute("usuario", usuario);
            return "perfil";
        }

        return "redirect:/login/";
    }
    /*
    @PostMapping("/recuperarContrasena/")
    public String busacurUsuario(Usuario usuario, Model model) {
        List<Usuario> usuarios = iUsuarioDao.findByCorreo(usuario.getCorreo());
        String dbEstadoCivil = usuarios.get(0).getEstado_civil().toString();
        String dbNacionalidad = usuarios.get(0).getNacionalidad().toString();
        String usuarioEstadoCivil = usuario.getEstado_civil().toString();
        String usuarioNacionalidad = usuario.getNacionalidad().toString();

        if (dbEstadoCivil == usuarioEstadoCivil ) {
            return "hi";
        }

        return ""+dbEstadoCivil+dbNacionalidad+usuarioEstadoCivil+usuarioNacionalidad+"";
    }
     */
 /*
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
     */
}
