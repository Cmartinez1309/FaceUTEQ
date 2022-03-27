/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Models.Solicitud;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface ISolicitudServiceImp {

    public List<Solicitud> listarSolicitud();

    public void guardar(Solicitud solicitud);

    public void eliminar(Solicitud solicitud);

    public Solicitud encontrarSolicitud(Solicitud solicitud);
}
