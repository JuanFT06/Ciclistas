/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.dao;

import com.example.JFigueroaBisoft.jpa.Ciclista;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

/**
 *
 * @author digis
 */
public interface ICiclistaDAO extends ListCrudRepository<Ciclista, Integer>{
    List<Ciclista> findAllByNombreContainingIgnoreCase(String nombre);
}