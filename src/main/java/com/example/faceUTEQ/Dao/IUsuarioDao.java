package com.example.faceUTEQ.Dao;

import com.example.faceUTEQ.Models.Usuario;
import java.util.List;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    List<Usuario> findByCorreo(String email);

    List<Usuario> findByCorreoAndNacionalidadAndNombre(String email, String nacionalidad, String nombre);
}
