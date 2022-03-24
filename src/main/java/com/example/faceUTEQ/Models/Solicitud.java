/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.faceUTEQ.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_soli;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_usu")
    @NotNull
    private Long Id_envia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id_usu")
    @NotNull
    private Long Id_recibe;

    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    private String Estatus;
}
