/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.dao;

import com.alvarez.entidades.Usuario;
import com.alvarez.excepciones.ConsultarException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class UsuarioDao extends GenericaDao<Usuario> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ayudat-PU"); // Manejador de persistencia persistence.xml

    EntityManager em = emf.createEntityManager();

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario getUsuarioByCredenciales(String usuario, String pwd) throws ConsultarException {
        try {
            Query q = em.createQuery("select u from Usuario as u where u.usuario=:usuario and u.pwd=:pwd");
            q.setParameter("usuario", usuario);
            q.setParameter("pwd", pwd);
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ConsultarException("Error al consultar login", e);
        }
    }
}
