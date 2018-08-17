/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10.controller;

import completo.semana10.dao.DaoFactura;
import completo.semana10.model.Factura;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class FacturaController {
    
    
    
    DaoFactura factura1 = new DaoFactura();
  
   
   public List<Factura> getFactura()
   {
       List<Factura> tmp= factura1.obtenerFacturas();
       if(tmp!=null)
       {
           return tmp;
       }
       else
       {
           return null;
       }
   }
}
