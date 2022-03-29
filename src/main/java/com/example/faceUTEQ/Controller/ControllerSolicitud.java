/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.faceUTEQ.Controller;

import com.example.faceUTEQ.Models.Solicitud;
import com.example.faceUTEQ.Service.ISolicitudServiceImp;
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
public class ControllerSolicitud {
    
     @RequestMapping("solicitud/")
    public String page(Model model) {
        model.addAttribute("nombre", "Hola desde Controlador Solicitud");
        return "index";
    }

    @Autowired
    private ISolicitudServiceImp iSolicitudService;

  //  @Autowired
  //  private ICategoriaService categoriaService;
    

    @GetMapping("index/solicitud/")
    public String listaSolicitud(Model model) {
        List<Solicitud> solicitud = iSolicitudService.listarSolicitud();
        model.addAttribute("solicitud", solicitud);
        return "index/solicitud";
    }

    @GetMapping("index/agregarSolicitud/")
    public String agregarSolicitudPage(Solicitud solicitud, Model model) {
      //  List<Categoria> categoria = categoriaService.listarCategoria();
      //  model.addAttribute("categoria2", categoria);
        return "index/agregarSolicitud";
    }

    @PostMapping("index/agregarSolicitud/")
    public String agregarSolicitud(@Valid Solicitud solicitud, Errors error,Model model) {
        if (error.hasErrors()) {
           // List<Categoria> categoria = categoriaService.listarCategoria();
           // model.addAttribute("categoria2", categoria);
            return "index/agregarSolicitud";
        }
        iSolicitudService.guardar(solicitud);
        return "redirect:/index/solicitud/";
    }

    @GetMapping("/index/editarSolicitud/{Id_soli}")
    public String editarSolicitud(Solicitud solicitud, Model model) {
        solicitud = iSolicitudService.encontrarSolicitud(solicitud);
        model.addAttribute("solicitud", solicitud);
        
       // List<Categoria> categoria = categoriaService.listarCategoria();
      //  model.addAttribute("categoria", categoria);
        return "index/modificarSolicitud";
    }

    @GetMapping("index/borrar/{idSolicitud}")
    public String borrarSolicitud(Solicitud solicitud) {
        iSolicitudService.eliminar(solicitud);
        return "index/table-datatable";
    }
    
}
