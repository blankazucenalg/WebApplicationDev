/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;
import com.proyecto.entidades.Curso;
import java.util.List;

/**
 *
 * @author Toño Castro
 */
public interface CursoDao {
 public List <Curso> mostrarCuros();
 public  void insertarCurso (Curso curso);
 public void  modificarCurso (Curso curso);
 public  void eliminarCurso (Curso curso);
 
}
