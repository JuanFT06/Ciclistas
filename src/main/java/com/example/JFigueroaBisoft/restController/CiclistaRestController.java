/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.restController;

import com.example.JFigueroaBisoft.dao.CiclistaDAOImplementation;
import com.example.JFigueroaBisoft.jpa.Ciclista;
import com.example.JFigueroaBisoft.jpa.Clase;
import jakarta.websocket.server.PathParam;
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
@RequestMapping("/api/ciclistas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CiclistaRestController {

    private final CiclistaDAOImplementation ciclistaDAOImplementation;

    public CiclistaRestController(com.example.JFigueroaBisoft.dao.CiclistaDAOImplementation ciclistaDAOImplementation) {
        this.ciclistaDAOImplementation = ciclistaDAOImplementation;
    }

    @GetMapping("")
    public ResponseEntity<List<Ciclista>> getAll() {
        List<Ciclista> ciclistas = this.ciclistaDAOImplementation.getAll();

        return ResponseEntity.ok(ciclistas);
    }

    @GetMapping("/getByNivel")
    public ResponseEntity<List<Ciclista>> getByNivel(@RequestParam("idnivel") int id) {
        List<Ciclista> ciclistas = this.ciclistaDAOImplementation.getAllByNivel(id);

        return ResponseEntity.ok(ciclistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciclista> getById(@PathVariable("id") int id) {
        Ciclista ciclista = this.ciclistaDAOImplementation.getById(id);
        return ResponseEntity.ok(ciclista);
    }

    @PostMapping("")
    public ResponseEntity<Ciclista> Add(@RequestBody Ciclista ciclista) {
        Ciclista newCiclista = ciclistaDAOImplementation.Add(ciclista);

        return ResponseEntity.status(200).body(newCiclista);

    }

    @PostMapping("/nombre")
    public ResponseEntity<List<Ciclista>> getAllByName(@RequestBody Ciclista ciclista) {

        List<Ciclista> ciclistas = this.ciclistaDAOImplementation.getByName(ciclista.getNombre());
        return ResponseEntity.ok(ciclistas);

    }

    @PostMapping("/apendClass/{id}")
    public ResponseEntity<String> apendClass(@RequestBody int[] lista, @PathVariable("id") int id) {

        for (int i : lista) {
            Ciclista ciclista = this.ciclistaDAOImplementation.getById(i);
            Clase clase= new Clase();
            clase.setId(id);
            ciclista.setClase(clase);

            this.ciclistaDAOImplementation.Add(ciclista);
        }

        return ResponseEntity.ok().body("agregados");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciclista> Update(@PathVariable("id") int id, @RequestBody Ciclista ciclista) {
        ciclista.setId(id);
        if (this.ciclistaDAOImplementation.exist(id)) {
            Ciclista newCiclista = ciclistaDAOImplementation.Update(ciclista);
            return ResponseEntity.status(200).body(newCiclista);
        }
        return (ResponseEntity<Ciclista>) ResponseEntity.badRequest();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if (this.ciclistaDAOImplementation.exist(id)) {
            this.ciclistaDAOImplementation.delete(id);
            return ResponseEntity.ok().body("eliminado correctamente");
        } else {
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
    }

}
