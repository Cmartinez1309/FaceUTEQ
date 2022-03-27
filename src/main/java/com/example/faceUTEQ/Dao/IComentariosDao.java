package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentariosDao extends JpaRepository<Comentarios, Long> {

    //List<Comentarios> findByid_cmt(String id_cmt);
}
