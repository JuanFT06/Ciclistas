/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author digis
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="ciclista")
public class Ciclista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idciclista")
    private int id;
    
    private String nombre;
    
    private String direccion;
    
    private int edad;
    
    @Column(name="membresiaactiva")
     private boolean membresiaActiva;
   
    @ManyToOne
    @JoinColumn(name="idnivel")
    private Nivel nivel;
}
