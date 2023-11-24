/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.dao;

import com.example.JFigueroaBisoft.jpa.Ciclista;
import com.example.JFigueroaBisoft.jpa.Nivel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class CiclistaDAOImplementation {

    private final ICiclistaDAO repository;
    private final INivelDAO nivelDAO;
    
    @Autowired
    public CiclistaDAOImplementation(com.example.JFigueroaBisoft.dao.ICiclistaDAO repository, com.example.JFigueroaBisoft.dao.INivelDAO nivelDAO) {
        this.repository = repository;
        this.nivelDAO = nivelDAO;
    }
    
    public Ciclista Add(Ciclista ciclista){
        Nivel nivel=this.nivelDAO.findByDescripcion(ciclista.getNivel().getDescripcion());
        ciclista.getNivel().setId(nivel.getId());
        Ciclista newCiclista= repository.save(ciclista);
        
        return newCiclista;
        
    }
    
     public Ciclista Update(Ciclista ciclista){
        Ciclista newCiclista= repository.save(ciclista);
        return newCiclista;
        
    }
    
    public List<Ciclista> getAll(){
        return this.repository.findAll();
    }
    
    public List<Ciclista> getByName(String name){
        return this.repository.findAllByNombreContainingIgnoreCase(name);
    }
    public Ciclista getById(int id){
        return this.repository.findById(id).orElse(null);
    }
    
    public boolean exist(int id){
        return this.repository.existsById(id);
    }
    
    public void delete(int id){
        this.repository.deleteById(id);
    }
    
}
