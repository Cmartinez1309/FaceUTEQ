/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Models.Comentarios;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IComentariosServiceImp {

    public List<Comentarios> listarComentarios();

    public void guardar(Comentarios comentarios);

    public void eliminar(Comentarios comentarios);

    public Comentarios encontrarComentarios(Comentarios comentarios);
}
