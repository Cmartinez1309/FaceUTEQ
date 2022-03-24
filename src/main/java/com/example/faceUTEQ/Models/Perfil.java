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

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Nombre;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Carrera;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Prepa;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Empresa;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Nacionalidad;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Estado_civil;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Gustos;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Img_perfil;
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_nivel")
    @NotNull
    private Long Id_nivel;
    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usu")
    @NotNull
    private long Id_usu;
}
