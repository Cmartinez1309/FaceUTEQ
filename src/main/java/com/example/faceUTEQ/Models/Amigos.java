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
import lombok.Data;

@Data
@Entity
@Table(name = "Amigos")
public class Amigos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_amig;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_envia")
    @NotNull
    private Usuario id_envia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_recibe")
    @NotNull
    private Usuario id_recibe;

    @NotEmpty
    @NotNull(message = "No debe ser nulo")
    @Size(min = 1, message = "No debe ser nulo")
    private String estatus;
    
    private boolean accountVerified;

}
