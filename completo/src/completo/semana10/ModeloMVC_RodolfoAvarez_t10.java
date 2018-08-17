/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10;

import completo.semana10.controller.DetalleController;
import completo.semana10.controller.FacturaController;
import completo.semana10.controller.UsuarioController;
import completo.semana10.dao.DaoDetalle;
import completo.semana10.dao.DaoFactura;
import completo.semana10.dao.DaoUsuario;
import completo.semana10.model.Conexion;
import completo.semana10.model.Detalle;
import completo.semana10.model.Factura;
import completo.semana10.model.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class ModeloMVC_RodolfoAvarez_t10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Usuario userIn = null;
        Conexion conexionBD = new Conexion();
        DaoUsuario crudus = new DaoUsuario();
        if (conexionBD.getConexionPostgrest() != null) {
            System.out.println("Conexion Exitosa");

            Usuario usuario = new Usuario();
            //documento corresponde a numero de cedula
            //no puede exitir dcument duplicados
            //validar por bd o por codigo

            usuario.setDocumento("32165498734");
            userIn = crudus.buscarFindByDocumento(usuario.getDocumento());
            if (userIn != null) {
                throw new Exception("Documentos repetidos para usuarios");
            }
            usuario.setNombre("RODOLFO");
            usuario.setApellido("ALVAREZ");
            usuario.setDireccion("SANTA.BARBARA");
            usuario.setTelefono("2636362");

            crudus.registrarUsuario(usuario);
            /////

            UsuarioController usercont = new UsuarioController();
            List<Usuario> recupera = new ArrayList<Usuario>();
            recupera = usercont.getUsuario();
            for (Usuario tmp : recupera) {
                System.err.println("" + tmp.toString());
            }

            userIn = crudus.buscarFindByDocumento(usuario.getDocumento());
            if (userIn != null) {
                Factura factura = new Factura();
                factura.setId_usuario(userIn.getId_usuario());
                factura.setFecha(new Date());
                UUID codigo = UUID.randomUUID();
                factura.setCodigo(codigo.toString());
                /////
                DaoFactura crudus1 = new DaoFactura();
                crudus1.registrarFactura(factura);
                ////

                FacturaController faccontrol = new FacturaController();
                List<Factura> recufac = new ArrayList<Factura>();
                recufac = faccontrol.getFactura();
                for (Factura tmp : recufac) {
                    System.err.println("" + tmp.toString());
                }
                Factura fcta = crudus1.facturaFindByCodigo(factura.getCodigo());
                if (fcta == null) {
                    throw new Exception("No es posible recupera la factura");
                }
                Detalle detalle = new Detalle();

                detalle.setId_detalle(1);
                detalle.setId_factura(fcta.getId_factura());
                detalle.setValor(new BigDecimal(12));
                detalle.setProducto("ARROZ");
                detalle.setCantidad(10);
                detalle.setPrecioTotal(new BigDecimal(120));
                ////
                DaoDetalle crudus2 = new DaoDetalle();
                crudus2.registrarDetalle(detalle);

                /////
                DetalleController det1 = new DetalleController();
                List<Detalle> recud = new ArrayList<Detalle>();
                recud = det1.getDetalle();
                for (Detalle tmp : recud) {
                    System.err.println("" + tmp.toString());
                }
            }
        }
    }
}
