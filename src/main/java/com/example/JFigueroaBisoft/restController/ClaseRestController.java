/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.restController;

import com.example.JFigueroaBisoft.dao.ClaseDAOImplementation;
import com.example.JFigueroaBisoft.jpa.Clase;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api/clases")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClaseRestController {

    public ClaseRestController(com.example.JFigueroaBisoft.dao.ClaseDAOImplementation service) {
        this.service = service;
    }
    
    private final ClaseDAOImplementation service;
    
    @GetMapping("")
    public ResponseEntity<List<Clase>> getAll(){
        List<Clase> clases=this.service.getAll();
        return ResponseEntity.ok(clases);
    }
    
    @GetMapping("/getByNivel")
    public ResponseEntity<List<Clase>> getByNivel(@RequestParam("idnivel")int idnivel){
        List<Clase> clases=this.service.getAllByNivel(idnivel);
        return ResponseEntity.ok(clases);
    }
    
    
    @PostMapping("")
    public ResponseEntity<Clase> add(@RequestBody Clase clase){
        if (this.service.claseExistente(clase)) {
            return ResponseEntity.badRequest().build();
        }
        Clase newClase=this.service.add(clase);
        return ResponseEntity.status(201).body(newClase);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Clase> getById(@PathVariable("id")int id){
        Clase clase= this.service.getById(id);
        
        if(clase!=null){
            return ResponseEntity.ok(clase);
        }
        
        return ResponseEntity.notFound().build();
    }
     
    @PutMapping("/{id}")
    public ResponseEntity<Clase> update(@PathVariable("id")int id,@RequestBody Clase clase){
        if (this.service.exist(id)) {
            clase.setId(id);
            Clase newClase=this.service.add(clase);
            return ResponseEntity.status(201).body(newClase);
        }else{
            return ResponseEntity.notFound().build();
        }  
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        this.service.delete(id);
        return ResponseEntity.ok().body("eliminado correctamente");
    }
}
