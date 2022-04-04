package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Amigos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IAmigosDao extends JpaRepository<Amigos, Long> {

    //List<Amigos> findById_enviaAndId_recibe(String id, String id2);
    // List<Amigos> findByIdenvia(String id_envia);
    //List<Amigos> findById_recibe(String d_recibe);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Amigos e set e.estatus = ?1 where e.id_amig = ?2")
    int updateUserNameById(String firstname, Long userId);
}
