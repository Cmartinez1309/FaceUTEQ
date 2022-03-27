/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Models.Publicacion;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IPublicacionServiceImp {

    public List<Publicacion> listarPublicacion();

    public void guardar(Publicacion publicacion);

    public void eliminar(Publicacion publicacion);

    public Publicacion encontrarPublicacion(Publicacion publicacion);
}
