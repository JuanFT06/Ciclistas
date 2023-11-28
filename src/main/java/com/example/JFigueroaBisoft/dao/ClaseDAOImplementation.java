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
    
    public List<Clase> getAllByNivel(int id){
        return this.iClaseDAO.findAllByNivelId(id);
    }
    
    public Clase getById(int id){
        return this.iClaseDAO.findById(id).orElse(null);
    }
    
    public Clase add(Clase clase){
        return this.iClaseDAO.save(clase);
    }
    
    public boolean claseExistente(Clase clase){
        Clase newClase= this.iClaseDAO.findByHorarioEquals(clase.getHorario());
        if (newClase!=null) {
            if (newClase.getAula().getId()==clase.getAula().getId()) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean exist(int id){
        return this.iClaseDAO.existsById(id);
    }
    
    
    public void delete(int id){
        this.iClaseDAO.deleteById(id);
    }
}
