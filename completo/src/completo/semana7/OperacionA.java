/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana7;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bn
 */
public class OperacionA {
    
     public static void  crearArchivo(ArrayList<Detalle> lista) {
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("C:\\archivos\\Factura.txt");
			
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Detalle detalle : lista) {
			
				bfwriter.write(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "," + detalle.getPvendido()+ "," + detalle.getCvendida()+ "," + detalle.getPventa()+ 
                                        "," + detalle.getDescripcionV()+"," + detalle.getEmpresa()+"," + detalle.getFecha()+ "," + detalle.getClave()+"\n");
			}
			
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<Detalle> leerArchivo() {
	
		File file = new File("C:\\archivos\\estudiantes.txt");
		ArrayList listaEstudiantes= new ArrayList<Detalle>();	
		Scanner scanner;
		try {
			
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
							
				delimitar.useDelimiter("\\s*,\\s*");
				Detalle d= new Detalle();
				d.setNombre(delimitar.next());
				d.setApellido(delimitar.next());
				d.setCedula(delimitar.next());
                                d.setNumeroVenta(delimitar.next());
				d.setPvendido(delimitar.next());
				d.setCvendida(delimitar.next());
                                d.setPventa(delimitar.next());
                                d.setDescripcionV(delimitar.next());
                                d.setEmpresa(delimitar.next());
                                d.setRuc(delimitar.next());
                                d.setFecha(delimitar.next());
                                d.setClave(delimitar.nextInt());
				
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaEstudiantes;
	}
	
	
	public static void aniadirArchivo(ArrayList<Detalle> lista) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("C:\\archivos\\estudiantes.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Detalle detalle : lista) {
				
				bfwriter.write(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "," + detalle.getPvendido()+ "," + detalle.getCvendida()+ "," + detalle.getPventa()+ 
                                        "," + detalle.getDescripcionV()+"," + detalle.getEmpresa()+"," + detalle.getFecha()+"," + detalle.getClave()+"\n");
			}
			bfwriter.close();
			System.out.println("Archivo modificado satisfactoriamente..");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	

   
}

