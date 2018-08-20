/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.dao;

import com.alvarez.excepciones.ConsultarException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author USUARIO
 */
public abstract class GenericaDao<T> {

    private Class<T> entityClass;

    public GenericaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     */
    public void guardar(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e.toString());
            //System.out.println(e.getMessage());
        }
    }

    public boolean guardarBoolean(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar");
            return false;
            //System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param entityList
     */
    public void guardarLista(List<T> entityList) {
        getEntityManager().getTransaction().begin();
        for (T temp : entityList) {
            getEntityManager().persist(temp);
        }
        getEntityManager().getTransaction().commit();
    }

    public boolean guardarListaBoolean(List<T> entityList) {
        try {
            getEntityManager().getTransaction().begin();
            for (T temp : entityList) {
                getEntityManager().persist(temp);
            }
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar");
            return false;
        }

    }

    /**
     *
     * @param entity
     */
    public void modificar(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    /**
     *
     * @param entity
     */
    public void eliminar(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    /**
     *
     * @param entityList
     */
    public void eliminarLista(List<T> entityList) {
        for (T temp : entityList) {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(temp));
            getEntityManager().getTransaction().commit();
        }

    }

    /**
     *
     * @param id
     * @return
     */
    public T buscar(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     *
     * @return
     */
    public List<T> buscarTodos() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     *
     * @param range
     * @return
     */
    public List<T> buscarPorRango(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     *
     * @return
     */
    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> listaGenerica(Map parametros) throws ConsultarException {
        try {
            Iterator it = parametros.entrySet().iterator();
            String where = "";
            String order = "";
            boolean all = false;
            int maximo = -1;
            int primero = -1;
            String table = entityClass.getSimpleName();
            Map par = new HashMap();

            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String clave = (String) e.getKey();
                if (clave.contains(";where")) {
                    where = (String) e.getValue();
                } else if (clave.contains(";inicial")) {
                    primero = (Integer) e.getValue();
                    all = true;
                } else if (clave.contains(";orden")) {
                    order = " order by " + (String) e.getValue();

                } else if (clave.contains(";final")) {
                    all = true;
                    maximo = (Integer) e.getValue();
                } else {
                    par.put(clave, e.getValue());
                }
            }
            if (!where.isEmpty()) {
                where = "where  " + where;
            }
            String sql = "Select object(o) from " + table + "  as o  " + where + order;
            Query q = getEntityManager().createQuery(sql);
            it = par.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String clave = (String) e.getKey();
                q.setParameter(clave, e.getValue());
            }
            if (all) {
                q.setMaxResults(maximo);
                q.setFirstResult(primero);
            }
            return q.getResultList();
        } catch (Exception e) {
            throw new ConsultarException(entityClass.toString(), e);

        }
    }

    public int contar(Map parametros) throws ConsultarException {
        try {
            Iterator it = parametros.entrySet().iterator();
            String where = "";
            String orden = "";
            boolean all = false;
            int maxResults = -1;
            int firstResult = -1;
            String tabla = entityClass.getSimpleName();
            Map par = new HashMap();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String clave = (String) e.getKey();
                if (clave.contains(";where")) {
                    where = (String) e.getValue();
                } else if (clave.contains(";inicial")) {
                    firstResult = (Integer) e.getValue();
                    all = true;
                } else if (clave.contains(";orden")) {
                    orden = " order by " + (String) e.getValue();

                } else if (clave.contains(";final")) {
                    all = true;
                    maxResults = (Integer) e.getValue();
                } else {
                    par.put(clave, e.getValue());
                }

            }
            if (!where.isEmpty()) {
                where = " where " + where;
            }

            String sql = "Select count(o) from " + tabla + " as o " + where;
            javax.persistence.Query q = getEntityManager().createQuery(sql);

            it = par.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String clave = (String) e.getKey();
                q.setParameter(clave, e.getValue());
            }
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            throw new ConsultarException(entityClass.toString(), e);
        }

    }

    public List<Object[]> sumar(Map parametros) throws ConsultarException {

        List<Object[]> retorno = null;
        Iterator it = parametros.entrySet().iterator();
        String where = "";
        String grupo = "";
        String campo = "";
        String orden = "";
        String suma = "";
        boolean all = false;
        int maxResults = -1;
        int firstResult = -1;
        String tabla = entityClass.getSimpleName();
        Map par = new HashMap();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            String clave = (String) e.getKey();
            if (clave.contains(";where")) {
                where = (String) e.getValue();

            } else if (clave.contains(";inicial")) {
                firstResult = (Integer) e.getValue();
                all = true;
            } else if (clave.contains(";campo")) {
                grupo = " group by " + (String) e.getValue();
                campo = (String) e.getValue();
            } else if (clave.contains(";suma")) {
                suma = (String) e.getValue();

            } else if (clave.contains(";orden")) {
                orden = " order by " + (String) e.getValue();

            } else if (clave.contains(";final")) {
                all = true;
                maxResults = (Integer) e.getValue();
            } else {
                par.put(clave, e.getValue());
            }

        }
        if (!where.isEmpty()) {
            where = " where " + where;
        }

        String sql = "Select " + campo + "," + suma + " from " + tabla + " as o " + where + grupo + orden;
        javax.persistence.Query q = getEntityManager().createQuery(sql);
//        if (all) {
//            q.setMaxResults(maxResults);
//            q.setFirstResult(firstResult);
//        }
        it = par.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            String clave = (String) e.getKey();

            q.setParameter(clave, e.getValue());
        }
        retorno = q.getResultList();

        return retorno;
    }

}
