package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Amigos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAmigosDao extends JpaRepository<Amigos, Long> {

    List<Amigos> findById_enviaAndId_recibe(String id, String id2);

    List<Amigos> findById_envia(String id);

    List<Amigos> findById_recibe(String id);
}
