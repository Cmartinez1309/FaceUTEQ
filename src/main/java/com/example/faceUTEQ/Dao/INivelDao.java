package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Nivel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INivelDao extends JpaRepository<Nivel, Long> {

    List<Nivel> findById_nivel(String Id_nivel);
}
