/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Models.Amigos;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IAmigosServiceImp {

    public List<Amigos> listarAmigos();

    public void guardar(Amigos amigos);

    public void eliminar(Amigos amigos);

    public Amigos encontrarAmigos(Amigos amigos);
}
