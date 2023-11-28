/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/clases")
public class ClasesController {
    
    @GetMapping("")
    public String getAll(){
        return "formClases";
    }
    @GetMapping("/all")
    public String getAllLocal(){
        return "clases";
    }
}
