/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana9;


import completo.semana9.conexion.Conexion;
import completo.semana9.dao.DaoDetalle;
import completo.semana9.dao.DaoFactura;
import completo.semana9.dao.DaoUsuario;
import completo.semana9.model.Detalle;
import completo.semana9.model.Factura;
import completo.semana9.model.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class BaseDatosPostgreSql {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
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
            List<Usuario> usu = crudus.obtenerUsuarios();
            usu.forEach((tmp) -> {
                System.err.println("" + tmp.toString());
            });

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
                List<Factura> factu = crudus1.obtenerFacturas();
                factu.forEach((tmp) -> {
                    System.err.println("" + tmp.toString());
                });
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
                List<Detalle> deta = crudus2.obtenerDetalle(fcta.getId_factura());
                deta.forEach((tmp) -> {
                    System.err.println("" + tmp.toString());
                });

            } else {
                System.out.println("no existe usuario de acuerdo a la busqueda");
            }

        }
    }
}
