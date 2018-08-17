/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.controller;

import com.uisrael.mvc.daoImpl.DaoFactura;
import com.uisrael.mvc.entidades.Factura;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class FacturaController {

    private static FacturaController instace;
    private static DaoFactura facturaDao;

    public static FacturaController getInstance() {
        if (instace == null) {
            instace = new FacturaController();
            facturaDao = DaoFactura.getInstace();
        }
        return instace;
    }

    public List<Factura> getFacturas() {
        facturaDao = DaoFactura.getInstace();
        List<Factura> tmp = facturaDao.obtenerFacturas();

        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }

    }

    public boolean guardar(Factura factura) {
        return facturaDao.registrarFactura(factura);
    }

    public boolean editar(Factura factura) {
        return facturaDao.editarFactura(factura);
    }

    public boolean eliminar(Factura factura) {
        return facturaDao.eliminarFactura(factura);
    }

    public Factura getFacturaByCodigo(String codigo) {
        return facturaDao.facturaFindByCodigo(codigo);
    }
}
