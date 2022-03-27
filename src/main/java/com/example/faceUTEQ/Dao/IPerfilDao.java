package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Perfil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilDao extends JpaRepository<Perfil, Long> {

    //List<Perfil> findById_usu(String Id_usu);
}
