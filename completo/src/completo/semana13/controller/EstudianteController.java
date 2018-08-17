/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana13.controller;



import completo.semana13.dao.EstudianteDAOImpl;
import completo.semana13.model.Estudiante;
import static completo.semana13.vista.JfrmEstudiante.txbusqueda;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author mrperez
 */
public class EstudianteController {

    public EstudianteDAOImpl estudiantedao;

    public EstudianteController() {
        estudiantedao = new EstudianteDAOImpl();
    }

    public void insertarUsuario(Estudiante nuevo) {
        try {
            int idEstudiante= estudiantedao.getMaxID();
            nuevo.setId(idEstudiante);
            estudiantedao.registrar(nuevo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizarUsuario(Estudiante actualizar)
         {
      
            try {
                if(actualizar.getId()!=0)
                {
                    estudiantedao.actualizar(actualizar);
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "No existe Seleccionado Estudiante"); 
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
            }

    }  
    

    
    public void eliminarUsuario(Estudiante eliminar)
        {
            try {
                if(eliminar.getId()!=0)
                {
                    estudiantedao.eliminar(eliminar);
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "No existe Seleccionado Estudiante"); 
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
            }

        }
    
    public List<Estudiante> getListEstudiante()
        {
            return estudiantedao.obtener();
        }
    
    public  List<Estudiante> getListEstudianteapellido()
        {
            
          return estudiantedao.obtenernomebreapellido(txbusqueda.getText());
        }


    }
