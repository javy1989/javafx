/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana6;
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
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("C:\\documentos\\Factura.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Detalle detalle : lista) {
				//escribe los datos en el archivo
				bfwriter.write(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "," + detalle.getPvendido()+ "," + detalle.getCvendida()+ "," + detalle.getPventa()+ 
                                        "," + detalle.getDescripcionV()+"," + detalle.getEmpresa()+"," + detalle.getFecha()+"\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//crea el archivo en disco, retorna la lista de estudiantes
	public static ArrayList<Detalle> leerArchivo() {
		// crea el flujo para leer desde el archivo
		File file = new File("C:\\documentos\\estudiantes.txt");
		ArrayList listaFacturas= new ArrayList<Detalle>();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma				
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
				listaFacturas.add(d);
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaFacturas;
	}
	
	//añadir más estudiantes al archivo
	public static void aniadirArchivo(ArrayList<Detalle> lista) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("C:\\archivos\\Facturas.txt", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (Detalle detalle : lista) {
				//escribe los datos en el archivo
				bfwriter.write(detalle.getNombre()+ "," + detalle.getApellido()+ "," + detalle.getCedula()
					+"," + detalle.getNumeroVenta()+ "," + detalle.getPvendido()+ "," + detalle.getCvendida()+ "," + detalle.getPventa()+ 
                                        "," + detalle.getDescripcionV()+"," + detalle.getEmpresa()+"," + detalle.getFecha()+"\n");
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
