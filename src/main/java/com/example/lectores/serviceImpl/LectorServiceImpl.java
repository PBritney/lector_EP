/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lectores.serviceImpl;

import com.example.lectores.dao.LectorDao;
import com.example.lectores.model.Lector;
import com.example.lectores.service.LectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BRITNEY
 */
@Service
public class LectorServiceImpl implements LectorService {

    @Autowired
    private LectorDao lectorDao;

    @Override
    public int create(Lector lec) {
        return lectorDao.create(lec);
    }

    @Override
    public int update(Lector lec) {
        return lectorDao.update(lec);
    }

    @Override
    public int delete(int id) {
        return lectorDao.delete(id);
    }

    @Override
    public Lector read(int id) {
        return lectorDao.read(id);
    }

    @Override
    public List<Lector> readAll() {
        return lectorDao.readAll();
    }

}
