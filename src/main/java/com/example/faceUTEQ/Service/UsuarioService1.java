/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Service;

import com.example.faceUTEQ.Dao.IUsuarioDao;
import com.example.faceUTEQ.Models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService1 implements IUsuarioServiceImp {

    @Autowired
    private IUsuarioDao usuariodao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuario() {
        return usuariodao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuariodao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuariodao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuariodao.findById(usuario.getId_usu()).orElse(null);

    }
}
