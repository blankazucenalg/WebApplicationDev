/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.entidades.Usuario;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Toño Castro
 */
public class UsuarioDaoImplement implements UsuarioDao{
    private Object NewHibernateUtil;

    @Override
    public List<Usuario> mostrarPersonas() {
      Session session = null;
      List<Usuario> lista=null;
        try {
            session =NewHibernateUtil.getSessionFactory().openSession();
            Query query= session.createQuery("from Usuario");
            lista = (List<Usuario>) query.list(); 
        } catch (HibernateException e) {
              System.out.println(e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
                
            }
            return lista;
            
        }
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
      Session session =null;
        try {
            session = NewHibernateUtil.getSessionFactory.openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void modifcarUsuario(Usuario usuario) {
        Session session=null;
        try {
            session = NewHibernateUtil.getSessionFactory.openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void EliminarUsuario(Usuario usuario) {
      Session session =null;
      try {
            session = NewHibernateUtil.getSessionFactory.openSession();
            session.beginTransaction();
            session.delate(usuario);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
}
