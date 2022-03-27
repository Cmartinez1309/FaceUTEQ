/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Models.Nivel;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface INivelServiceImp {

    public List<Nivel> listarNivel();

    public void guardar(Nivel nivel);

    public void eliminar(Nivel nivel);

    public Nivel encontrarNivel(Nivel nivel);
}
