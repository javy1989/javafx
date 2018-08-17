/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana8;



import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mrperez
 */
public class ComLuisAlvarezUisraelt7Model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Ingrese datos de EmpleadoS");
        List<EmpleadoS> empleado = new ArrayList();
        empleado.add(new EmpleadoS("LUIS","ALVAREZ","1722716592",2)); 
      

        OperacionArchivosSerializable.guardarArchivo(empleado);
        
        List<EmpleadoS> ingresoempleado = new ArrayList();
        ingresoempleado = OperacionArchivosSerializable.deserialzeEmpleadoS("serializa.txt");
        System.out.println(ingresoempleado);

    }
}
