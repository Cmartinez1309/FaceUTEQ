package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Publicacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublicacionDao extends JpaRepository<Publicacion, Long> {
     //List<Publicacion> findById_pb (String id_pb);
}
