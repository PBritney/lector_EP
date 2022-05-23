package com.example.lectores.controller;

import com.example.lectores.model.Lector;
import com.example.lectores.service.LectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BRITNEY
 */
@RestController
@RequestMapping("/lec")
public class LectorRestController {
    
    @Autowired
    private LectorService lectorService;
    
    @GetMapping("/all")
    public List<Lector>getPosts(){
        return lectorService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Lector> getLector(@PathVariable int id){
        Lector lec=lectorService.read(id);
        return ResponseEntity.ok(lec);
    }
    
    @DeleteMapping("/{id}")
    public int deleteLector(@PathVariable int id){
        return lectorService.delete(id);
    }
    
    @PostMapping("/add")
    public int addLector(@RequestBody Lector lec){
        System.out.println(lec.getNombres());
        return lectorService.create(lec);
    }
    
    @PutMapping("/edit")
    public int editLector(@RequestBody Lector lec){
        Lector le =new Lector(lec.getIdlector(),lec.getNombres(),lec.getApellidos(),lec.getCorreo());
        System.out.println(lec.getIdlector()+" , "+lec.getNombres()+" , "+lec.getApellidos()+" , "+lec.getCorreo());
        return lectorService.update(lec);
    }
}
