/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10.controller;


import completo.semana10.dao.DaoUsuario;
import completo.semana10.model.Usuario;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class UsuarioController {
    
    
     DaoUsuario user1 = new DaoUsuario();
   
   public List<Usuario> getUsuario()
   {
       List<Usuario> tmp= user1.obtenerUsuarios();
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
