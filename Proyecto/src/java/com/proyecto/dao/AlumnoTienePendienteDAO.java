/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.model.AlumnoTienePendiente;
import com.proyecto.model.Usuario;
import com.proyecto.utils.HibernateUtil;
import java.util.Collection;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author azu
 */
public class AlumnoTienePendienteDAO {

    public void create(AlumnoTienePendiente atp) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(atp);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void update(AlumnoTienePendiente atp) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.update(atp);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void delete(AlumnoTienePendiente atp) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.delete(atp);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public AlumnoTienePendiente load(AlumnoTienePendiente atp) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            atp = (AlumnoTienePendiente) session.get(AlumnoTienePendiente.class, atp.getIdatp());
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return atp;
    }

    public Collection loadAllForUser(Usuario alumno) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        List list = null;
        try {
            tx.begin();
            Query q = session.createQuery("from AlumnoTienePendiente as atp where atp.usuario = "+alumno.getIdusuario());
            list = q.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return list;
    }

}
