package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Perfil;
import com.example.faceUTEQ.Models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilDao extends JpaRepository<Perfil, Long> {

  //List<Perfil> findById_usu(Long Id_usu);
}
