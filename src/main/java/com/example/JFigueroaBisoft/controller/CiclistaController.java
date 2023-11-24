/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.JFigueroaBisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/ciclistas")
public class CiclistaController {
    @GetMapping("")
    public String getAll(Model model){
        
        return "index";
    }
    
    @GetMapping("/all")
    public String getAllLocal(Model model){
        
        return "local";
    }
}
