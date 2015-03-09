/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;
import com.proyecto.dao.CursoDao;
import com.proyecto.entidades.Curso;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
/**
 *
 * @author Toño Castro
 */
public class CursoDaoImplements implements CursoDao{

    @Override
    public List<Curso> mostrarCuros() {
       Session session=null;
       List<Curso> lista=null;
       try{
           session =NewHibernetUtil.getSessiomFactory().openSession();
           Query query=session.createQuery("from Curso");
           lista = (List<Curso>) query.list();
       }catch (HibernateException e){
           System.out.println(e.getMessage());
       }
       finally{
           if (session!=null) {
               session.close();
               
           }
           return lista;
       }
           
    }

    @Override
    public void insertarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
