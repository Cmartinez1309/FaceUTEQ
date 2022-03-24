/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_cmt;

    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String Contenido_cmt;
    
    @Column(name = "Fecha_cmt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_cmt;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        Fecha_cmt = new Date();
        Fecha_actializa = new Date();
    }

    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_usu")
    @NotNull
    private long Id_usu;

    //Es foranea investegir como se relaciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_pb")
    @NotNull
    private long Id_pb;
    @Column(name = "Fecha_actializa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_actializa;
    private String coment_id;
}
