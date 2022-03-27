/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author usuario
 */
@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "Correo"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id_usu;

    @NotEmpty
    @NotNull(message = "Debes especificar el cooreo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String Correo;

    @NotEmpty
    @NotNull(message = "Debes especificar la contrasena")
    @Size(min = 1, max = 50, message = "La contrasena debe medir entre 1 y 50")
    private String Contasena;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String role;

    public long getId_usu() {
        return Id_usu;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContasena() {
        return Contasena;
    }

    public void setId_usu(long Id_usu) {
        this.Id_usu = Id_usu;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setContasena(String Contasena) {
        this.Contasena = Contasena;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
