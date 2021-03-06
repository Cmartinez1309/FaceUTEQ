/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IComentariosDao;
import com.example.faceUTEQ.Models.Comentarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class ComentariosService implements IComentariosServiceImp {

    @Autowired
    private IComentariosDao comentariosDao;

    @Override
    public List<Comentarios> listarComentarios() {
        return comentariosDao.findAll();
    }

    @Override
    @Transactional
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
