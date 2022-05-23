/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.lectores.service;

import com.example.lectores.model.Lector;
import java.util.List;

/**
 *
 * @author BRITNEY
 */
public interface LectorService {
    int create(Lector lec);
    int update(Lector lec);
    int delete(int id);
    Lector read(int id);
    List<Lector> readAll();
}
