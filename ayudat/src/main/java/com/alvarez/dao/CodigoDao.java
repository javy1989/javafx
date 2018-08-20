/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.dao;

import com.alvarez.entidades.Codigo;
import com.alvarez.entidades.GrupoUsuario;
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
public class CodigoDao extends GenericaDao<Codigo> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ayudat-PU"); // Manejador de persistencia persistence.xml

    EntityManager em = emf.createEntityManager();

    public CodigoDao() {
        super(Codigo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
