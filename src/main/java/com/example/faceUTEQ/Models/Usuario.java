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
import lombok.Data;

/**
 *
 * @author usuario
 */
@Data
@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usu;

    @NotEmpty
    @NotNull(message = "Debes especificar el cooreo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String correo;

    @NotEmpty
    @NotNull(message = "Debes especificar la contrasena")
    @Size(min = 1, max = 50, message = "La contrasena debe medir entre 1 y 50")
    private String contrasena;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String role;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String nombre;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String carrera;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String prepa;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String empresa;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String nacionalidad;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String estado_civil;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String gustos;

    @NotEmpty
    @NotNull(message = "Debes especificar el correo")
    @Size(min = 1, message = "El correo no debe ser nulo")
    private String img_perfil;

    public long getId_usu() {
        return id_usu;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId_usu(long id_usu) {
        this.id_usu = id_usu;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setPrepa(String prepa) {
        this.prepa = prepa;
    }

    public String getPrepa() {
        return prepa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setEstadoCivil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEstadoCivil() {
        return estado_civil;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public String getGustos() {
        return gustos;
    }

    public void setImgPerfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public String getImgPerfil() {
        return img_perfil;
    }

    public Usuario(long id_usu, String correo, String contrasena, String role, String nombre, String carrera, String prepa, String empresa, String nacionalidad, String estado_civil, String gustos, String img_perfil) {
        this.id_usu = id_usu;
        this.correo = correo;
        this.contrasena = contrasena;
        this.role = role;
        this.nombre = nombre;
        this.carrera = carrera;
        this.prepa = prepa;
        this.empresa = empresa;
        this.nacionalidad = nacionalidad;
        this.estado_civil = estado_civil;
        this.gustos = gustos;
        this.img_perfil = img_perfil;

    }

    public Usuario(String correo, String contrasena, String role, String nombre, String carrera, String prepa, String empresa, String nacionalidad, String estado_civil, String gustos, String img_perfil) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.role = role;
        this.nombre = nombre;
        this.carrera = carrera;
        this.prepa = prepa;
        this.empresa = empresa;
        this.nacionalidad = nacionalidad;
        this.estado_civil = estado_civil;
        this.gustos = gustos;
        this.img_perfil = img_perfil;
    }

    public Usuario() {
        super();
    }
}