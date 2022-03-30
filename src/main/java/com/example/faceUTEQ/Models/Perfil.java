/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Models;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_rol;

    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String nombre;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String carrera;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String prepa;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String empresa;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String nacionalidad;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String estado_civil;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String gustos;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    public String img_perfil;
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_nivel")
    @NotNull
    public Nivel id_nivel;
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_usu")
    @NotNull
    public Usuario id_usu;


}
