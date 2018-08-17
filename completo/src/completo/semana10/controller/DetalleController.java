/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10.controller;

import completo.semana10.model.Detalle;
import completo.semana10.dao.DaoDetalle;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class DetalleController {

    DaoDetalle deta1 = new DaoDetalle();

    public List<Detalle> getDetalle() {
        List<Detalle> tmp = deta1.obtenerDetalle(0);
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }
}
