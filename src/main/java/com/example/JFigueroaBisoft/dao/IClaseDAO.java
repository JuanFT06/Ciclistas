/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.dao;

import com.example.JFigueroaBisoft.jpa.Clase;
import org.springframework.data.repository.ListCrudRepository;

/**
 *
 * @author digis
 */
public interface IClaseDAO  extends ListCrudRepository<Clase, Integer>{
    
    
    Clase findByHorarioEquals(String horario);
}
