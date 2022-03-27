/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IComentariosDao;
import com.example.faceUTEQ.Models.Comentarios;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ComentariosService implements IComentariosServiceImp {

    private IComentariosDao comentariosDao;

    @Override
    public List<Comentarios> listarComentarios() {
        return comentariosDao.findAll();
    }

    @Override
    public void guardar(Comentarios comentarios) {
        comentariosDao.save(comentarios);
    }

    @Override
    public void eliminar(Comentarios comentarios) {
        comentariosDao.delete(comentarios);
    }

    @Override
    public Comentarios encontrarComentarios(Comentarios comentarios) {
        return comentariosDao.findById(comentarios.getId_cmt()).orElse(null);
    }

}
