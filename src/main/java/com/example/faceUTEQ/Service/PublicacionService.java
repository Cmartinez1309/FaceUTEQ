/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IPublicacionDao;
import com.example.faceUTEQ.Models.Publicacion;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PublicacionService implements IPublicacionServiceImp {

    private IPublicacionDao publicacionDao;

    @Override
    public List<Publicacion> listarPublicacion() {
        return publicacionDao.findAll();
    }

    @Override
    public void guardar(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    public void eliminar(Publicacion publicacion) {
        publicacionDao.delete(publicacion);
    }

    @Override
    public Publicacion encontrarPublicacion(Publicacion publicacion) {
        return publicacionDao.findById(publicacionDao.getId_pb()).orElse(null);
    }

}
