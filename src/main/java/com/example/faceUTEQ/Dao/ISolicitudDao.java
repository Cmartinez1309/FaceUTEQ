package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long> {

    List<Solicitud> findById_soli(String Id_soli);
}
