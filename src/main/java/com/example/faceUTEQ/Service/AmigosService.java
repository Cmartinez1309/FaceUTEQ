/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IAmigosDao;
import com.example.faceUTEQ.Models.Amigos;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
public class AmigosService implements IAmigosServiceImp {

    private IAmigosDao amigosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Amigos> listarAmigos() {
        return amigosDao.findAll();
    }

    @Override
    public void guardar(Amigos amigos) {
        amigosDao.save(amigos);
    }

    @Override
    public void eliminar(Amigos amigos) {
        amigosDao.delete(amigos);
    }

    @Override
    public Amigos encontrarAmigos(Amigos amigos) {
        return amigosDao.findById(amigos.getId_amig()).orElse(null);
    }

}
