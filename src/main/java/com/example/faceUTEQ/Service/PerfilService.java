/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IPerfilDao;
import com.example.faceUTEQ.Models.Perfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class PerfilService implements IPerfilServiceImp {
    
    @Autowired
    private IPerfilDao iPerfilDao;
    
    @Override
    public List<Perfil> listarPerfil() {
        return iPerfilDao.findAll();
    }

    @Override
    public void guardar(Perfil perfil) {
        iPerfilDao.save(perfil);
    }
    
    @Override
    public void eliminar(Perfil perfil) {
        iPerfilDao.delete(perfil);
    }
    
    //ni puta idea xd ... es que no tiene pk primaria 
    @Override
    public Perfil encontrarPerfil(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
