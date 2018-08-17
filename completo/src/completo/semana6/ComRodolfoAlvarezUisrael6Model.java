/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana6;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author User
 */
public class ComRodolfoAlvarezUisrael6Model {

    /**
     * @param args the command line arguments
     */
    private static String produc;
    private static int opc1,opc2;
    public static void main(String[] args) {
        ArrayList listaFactura = new ArrayList<Factura>();
        Scanner teclado = new Scanner(System.in);
        java.util.Date fecha = new Date();
        
        // estudiante 1
        Detalle detalle1 = new Detalle();
        System.out.println("Ingrese nombre de estudiante : ");
        detalle1.setNombre("NOMBRE: "+teclado.next());
        System.out.println("Ingrese apellido de estudiante : ");
        detalle1.setApellido("APELLIDO: "+teclado.next());
        System.out.println("Ingrese la cedula : ");
        detalle1.setCedula("CEDULA: "+teclado.next());
        System.out.println("Ingrese el producto a vender: ");
        produc = teclado.next();
        detalle1.setPvendido("PRODUCTO:" +produc);
        System.out.println("Ingrese la cantidad: ");
        detalle1.setCvendida("CANTIDAD:" + teclado.next());
        System.out.println("Ingrese el precio: ");
        detalle1.setPventa("PRECIO:" + teclado.next());
        detalle1.setNumeroVenta("NUMERO VENTA:1 ");
        System.out.println("Registre la descripcion de " + produc + " :");

        detalle1.setDescripcionV("DESCRIPCION: " + teclado.next());
        System.out.println("Ingrese nombre de la empresa: ");
        detalle1.setEmpresa("EMPRESA: " + teclado.next());
        System.out.println("Ingrese el ruc : ");
        detalle1.setRuc("RUC:" + teclado.next());
        detalle1.setFecha("FECHA: "+fecha+"\n");

        // añade un estudiante a la lista
        listaFactura.add(detalle1);
         System.out.println("DESEA INGRESAR OTRO ESTUDIANTE  si =1, no =0 ? ");
        opc1= teclado.nextInt();
        
      if(opc1==1){
    
        // estudiante 2
        Detalle detalle2 = new Detalle();
        
         System.out.println("Ingrese nombre de estudiante : ");
        detalle2.setNombre("NOMBRE: "+teclado.next());
        System.out.println("Ingrese apellido de estudiante : ");
        detalle2.setApellido("APELLIDO: "+teclado.next());
        System.out.println("Ingrese la cedula : ");
        detalle2.setCedula("CEDULA: "+teclado.next());
        System.out.println("Ingrese el producto a vender: ");
        produc = teclado.next();
        detalle2.setPvendido("PRODUCTO:" +produc);
        System.out.println("Ingrese la cantidad: ");
        detalle2.setCvendida("CANTIDAD:" + teclado.next());
        System.out.println("Ingrese el precio: ");
        detalle2.setPventa("PRECIO:" + teclado.next());
        detalle2.setNumeroVenta("NUMERO VENTA:1 ");
        System.out.println("Registre la descripcion de " + produc + " :");

        detalle2.setDescripcionV("DESCRIPCION: " + teclado.next());
        System.out.println("Ingrese nombre de la empresa: ");
        detalle2.setEmpresa("EMPRESA: " + teclado.next());
        System.out.println("Ingrese el ruc : ");
        detalle2.setRuc("RUC:" + teclado.next());
        detalle2.setFecha("FECHA: "+fecha+"\n");
        
       
        // añade un estudiante a la lista
        listaFactura.add(detalle2);
        
         System.out.println("DESEA INGRESAR OTRO ESTUDIANTE  si =1, no =0 ? ");
        opc2= teclado.nextInt();
        
      if(opc2==1){
        
          // estudiante 3
        Detalle detalle3 = new Detalle();
        
         System.out.println("Ingrese nombre de estudiante : ");
        detalle3.setNombre("NOMBRE: "+teclado.next());
        System.out.println("Ingrese apellido de estudiante : ");
        detalle3.setApellido("APELLIDO: "+teclado.next());
        System.out.println("Ingrese la cedula : ");
        detalle3.setCedula("CEDULA: "+teclado.next());
        System.out.println("Ingrese el producto a vender: ");
        produc = teclado.next();
        detalle3.setPvendido("PRODUCTO:" +produc);
        System.out.println("Ingrese la cantidad: ");
        detalle3.setCvendida("CANTIDAD:" + teclado.next());
        System.out.println("Ingrese el precio: ");
        detalle3.setPventa("PRECIO:" + teclado.next());
        detalle3.setNumeroVenta("NUMERO VENTA:1 ");
        System.out.println("Registre la descripcion de " + produc + " :");

        detalle3.setDescripcionV("DESCRIPCION: " + teclado.next());
        System.out.println("Ingrese nombre de la empresa: ");
        detalle3.setEmpresa("EMPRESA: " + teclado.next());
        System.out.println("Ingrese el ruc : ");
        detalle3.setRuc("RUC:" + teclado.next());
        detalle3.setFecha("FECHA: "+fecha+"\n");

        // añade un estudiante a la lista
        listaFactura.add(detalle3);

      }else{
        // crea el archivo estudiantes
        OperacionA.crearArchivo(listaFactura);
        // lista para recibir los objetos estudiantes desde el archivo
        ArrayList listaLeida = new ArrayList<Detalle>();

        // asignar a la lista los objetos
        listaLeida = OperacionA.leerArchivo();
        for (Iterator it = listaLeida.iterator(); it.hasNext();) {
            Detalle detalle = (Detalle) it.next();
            System.out.println(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "\n"+"," + detalle.getPvendido()+ "\n"+"," + detalle.getCvendida()+ "\n"+"," + detalle.getPventa()+ 
                                       "\n"+ "," + detalle.getDescripcionV()+"\n"+"," + detalle.getEmpresa()+"\n"+"," + detalle.getFecha()+"\n");
    }
      
      
      }
        
      } else{
        // crea el archivo estudiantes
        OperacionA.crearArchivo(listaFactura);
        // lista para recibir los objetos estudiantes desde el archivo
        ArrayList listaLeida = new ArrayList<Detalle>();

        // asignar a la lista los objetos
        listaLeida = OperacionA.leerArchivo();
        for (Iterator it = listaLeida.iterator(); it.hasNext();) {
            Detalle detalle = (Detalle) it.next();
            System.out.println(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "\n"+"," + detalle.getPvendido()+ "\n"+"," + detalle.getCvendida()+ "\n"+"," + detalle.getPventa()+ 
                                       "\n"+ "," + detalle.getDescripcionV()+"\n"+"," + detalle.getEmpresa()+"\n"+"," + detalle.getFecha()+"\n");
    }
      
      
      }
      
      
      
      

        

    
    }
    
}
