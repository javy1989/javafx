/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.controller;

import com.alvarez.dao.UsuarioDao;
import com.alvarez.entidades.Usuario;
import com.alvarez.excepciones.ConsultarException;
import com.alvarez.util.AlertUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPwd;

    private UsuarioDao usuarioDao;
    private SessionUsuario session;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private String login(ActionEvent event) {
        try {
            usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.getUsuarioByCredenciales(txtUsuario.getText(), txtPwd.getText());
            if (usuario == null) {
                AlertUtil.error("Usuario o Contraseña incorrecta");
                txtPwd.setText("");
                return null;
            }
            session = SessionUsuario.getInstace();
            session.setSessionUsuario(usuario);
            if (session.getGrupo() == null) {
                AlertUtil.error("El usuario no posee perfil para el sistema");
                txtPwd.setText("");
                return null;
            }
            
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent home = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(home);
            stage.setScene(scene);
            stage.setTitle("Home");
            stage.setMaximized(true);    // make the main form fit to the screen
            stage.show();

            return null;
        } catch (ConsultarException ex) {
            System.out.println(ex.getCause());

            return null;
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
