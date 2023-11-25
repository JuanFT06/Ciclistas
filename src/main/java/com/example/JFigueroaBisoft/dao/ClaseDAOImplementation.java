/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.dao;

import com.example.JFigueroaBisoft.jpa.Clase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class ClaseDAOImplementation {

    @Autowired
    public ClaseDAOImplementation(com.example.JFigueroaBisoft.dao.IClaseDAO iClaseDAO) {
        this.iClaseDAO = iClaseDAO;
    }
    
    private final IClaseDAO iClaseDAO;
    
    public List<Clase> getAll(){
        return this.iClaseDAO.findAll();
    }
    
    public Clase add(Clase clase){
        return this.iClaseDAO.save(clase);
    }
    
    public boolean claseExistente(String horario){
        Clase clase= this.iClaseDAO.findByHorarioEquals(horario);
        if (clase!=null) {
            return true;
        }
        
        return false;
    }
}
