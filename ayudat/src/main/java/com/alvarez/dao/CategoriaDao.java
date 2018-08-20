/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.dao;

import com.alvarez.entidades.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class CategoriaDao extends GenericaDao<Categoria> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ayudat-PU"); // Manejador de persistencia persistence.xml

    EntityManager em = emf.createEntityManager();

    public CategoriaDao() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
