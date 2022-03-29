/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.ISolicitudDao;
import com.example.faceUTEQ.Models.Solicitud;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class SolicitudService implements ISolicitudServiceImp {

    private ISolicitudDao solicitudDao;

    @Override
    public List<Solicitud> listarSolicitud() {
        return solicitudDao.findAll();
    }

    @Override
    public void guardar(Solicitud solicitud) {
        solicitudDao.save(solicitud);
    }

    @Override
    public void eliminar(Solicitud solicitud) {
        solicitudDao.delete(solicitud);
    }

    @Override
    public Solicitud encontrarSolicitud(Solicitud solicitud) {
        return solicitudDao.findById(solicitud.getId_soli()).orElse(null);
    }

}
