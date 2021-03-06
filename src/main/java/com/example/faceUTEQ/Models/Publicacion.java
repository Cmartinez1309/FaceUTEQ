/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Models;

import java.util.Collection;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pb;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String contenido;
    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String img_pb;

    private Date fecha_pb;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        fecha_pb = new Date();
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_usu")
    @NotNull

    private Usuario id_usu;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_nivel")
    @NotNull

    private Nivel id_nivel;


}
