/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.model.Asignatura;
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
public class AsignaturaDAO {

    public void create(Asignatura a) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(a);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void update(Asignatura a) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.update(a);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void delete(Asignatura a) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.delete(a);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public Asignatura load(Asignatura a) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            a = (Asignatura) session.get(Asignatura.class, a.getIdasignatura());
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return a;
    }

    public Collection loadAll(int startID, int endID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        List list = null;
        try {
            tx.begin();
            Query q = session.createQuery("from Asignatura as asignatura where asignatura.idasignatura between '"+startID+"' and '"+endID+"'");
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
