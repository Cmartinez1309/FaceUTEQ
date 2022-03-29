/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IPublicacionDao;
import com.example.faceUTEQ.Models.Publicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class PublicacionService implements IPublicacionServiceImp {

    @Autowired
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

    //aqui no se que pedo
    @Override
    public Publicacion encontrarPublicacion(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
