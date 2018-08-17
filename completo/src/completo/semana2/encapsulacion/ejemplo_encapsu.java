/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana2.encapsulacion;

/**
 *
 * @author User
 */
import java.util.*;
public class ejemplo_encapsu {
    
    public int puntaje;
    private String respuesta;
    private final String[] animales;
    private final Scanner teclado;
    
    public ejemplo_encapsu(){
        puntaje=0;
        teclado= new Scanner(System.in);
        animales=new  String [2];
        animales[0]="perro";
        animales[1]="gato";
        
    }
    
    private void puntajePerro(){
        if(respuesta.equals(animales[0])){
            System.out.println("!Correcto tiene 10 puntos mas!");
            puntaje=puntaje+10;
        }else{
            System.out.println("!Incorrecto las respuesta es:"+animales[0]);
            System.out.println("1 punto menos");
            puntaje=puntaje-1;
        }
        
    }
    private void puntajeGato(){
        if(respuesta.equals(animales[1])){
            System.out.println("!Correcto tiene 10 puntos mas!");
            puntaje=puntaje+10;
        }else{
            System.out.println("!Incorrecto las respuesta es:"+animales[1]);
            System.out.println("1 punto menos");
            puntaje=puntaje-1;
        }
        
    }
    
    public void imprimePregunta(){
        System.out.println("Es un animal que ladra:");
        respuesta=teclado.nextLine();
        puntajePerro();
        
        System.out.println("Es un animal que maulla:");
        respuesta=teclado.nextLine();
        puntajeGato();
    }
}
