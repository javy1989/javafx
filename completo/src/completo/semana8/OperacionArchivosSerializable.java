/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rudolf
 */
public class OperacionArchivosSerializable {

    public static void guardarArchivo(List<EmpleadoS> nuevo) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("serializaempleadoS.txt");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(nuevo);
            }
            System.out.println("Archivo guardado correctamente");
           
        } catch (IOException ex) {
            Logger.getLogger(OperacionArchivosSerializable.class.getName()).log(Level.SEVERE, null, ex);
           
        }

    }

    public static List<EmpleadoS> deserialzeEmpleadoS(String filename) {
        List<EmpleadoS> empleado = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            empleado = (List<EmpleadoS>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("------");
        }
        return (List<EmpleadoS>)  empleado;
    }
}
