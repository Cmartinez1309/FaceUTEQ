package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
     List<Usuario> findByCorreo (String email);
}
