/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.INivelDao;
import com.example.faceUTEQ.Models.Nivel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class NivelService implements INivelServiceImp {

    private INivelDao nivelDao;

    @Override
    public List<Nivel> listarNivel() {
        return nivelDao.findAll();
    }

    @Override
    public void guardar(Nivel nivel) {
        nivelDao.save(nivel);
    }

    @Override
    public void eliminar(Nivel nivel) {
        nivelDao.delete(nivel);
    }

    @Override
    public Nivel encontrarNivel(Nivel nivel) {
        return nivelDao.findById(nivel.getId_nivel()).orElse(null);
    }

}
