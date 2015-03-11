/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.model.Historico;
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
public class HistoricoDAO {

    public void create(Historico h) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.saveOrUpdate(h);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void update(Historico h) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.update(h);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void delete(Historico h) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            session.delete(h);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public Historico load(Historico h) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        try {
            tx.begin();
            h = (Historico) session.get(Historico.class, h.getIdhistorico());
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return h;
    }

    public Collection loadAll(int startID, int endID) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.getTransaction();
        List list = null;
        try {
            tx.begin();
            Query q = session.createQuery("from Historico as history where history.idhistorico between '"+startID+"' and '"+endID+"'");
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
