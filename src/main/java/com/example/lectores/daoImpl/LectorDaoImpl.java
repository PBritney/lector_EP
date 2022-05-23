/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lectores.daoImpl;

import com.example.lectores.dao.LectorDao;
import com.example.lectores.model.Lector;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BRITNEY
 */
@Repository
public class LectorDaoImpl implements LectorDao {

    @Autowired//para traer la conexion
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Lector lec) {
        String SQL="INSERT INTO lectores(nombres,apellidos,correo) VALUES(?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{lec.getNombres(),lec.getApellidos(),lec.getCorreo()});
    }

    @Override
    public int update(Lector lec) {
        String SQL ="UPDATE lectores SET nombres=?, apellidos=?,correo=? WHERE idlector=?";                 
        return jdbcTemplate.update(SQL,new Object[]{lec.getNombres(),lec.getApellidos(),lec.getCorreo(),lec.getIdlector()});
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM lectores WHERE idlector=?"; 
        return jdbcTemplate.update(SQL,id);       
    }

    @Override
    public Lector read(int id) {
        String SQL ="SELECT * FROM lectores WHERE idlector=?";
        try {
            Lector lec = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Lector.class),id);
            return lec;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Lector> readAll() {
        String SQL ="SELECT idlector,nombres,apellidos,correo FROM lectores";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Lector.class));
    }
}

