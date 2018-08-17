/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.controller;

import com.uisrael.mvc.daoImpl.DaoDetalle;
import com.uisrael.mvc.entidades.Detalle;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class DetalleController {

    private static DetalleController instace;
    private static DaoDetalle daoDetalle;

    public static DetalleController getInstance() {
        if (instace == null) {
            instace = new DetalleController();
            daoDetalle = DaoDetalle.getInstance();
        }
        return instace;
    }

    public List<Detalle> getDetalle(int factura) {
        daoDetalle = DaoDetalle.getInstance();
        List<Detalle> tmp = daoDetalle.obtenerDetalle(factura);
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }

    public boolean guardar(Detalle detalle) {
        return daoDetalle.registrarDetalle(detalle);
    }

    public boolean editar(Detalle detalle) {
        return daoDetalle.editarDetalle(detalle);
    }
    
    public boolean eliminar(Detalle detalle){
        return daoDetalle.eliminarDetalle(detalle);
    }
}
