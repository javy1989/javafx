/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;


/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TitledPane tlIncidentes;
    @FXML
    private TitledPane tlMantenimiento;
    @FXML
    private Text txtUsuarioIn;
    @FXML
    private Button btnSalir;
    @FXML
    private VBox dataPane;

    private SessionUsuario session;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = SessionUsuario.getInstace();
        txtUsuarioIn.setText(session.getUsuario().toString());
        if (session.getGrupo().getGrupo().getParametros().compareTo("USR") == 0) {
            tlMantenimiento.setVisible(false);
            tlIncidentes.setVisible(true);
        }
        if (session.getGrupo().getGrupo().getParametros().compareTo("TEC") == 0) {
            tlMantenimiento.setVisible(true);
            tlIncidentes.setVisible(false);
        }

    }

    public void setDataPane(Node node) {
        dataPane.getChildren().setAll(node);
    }

    public VBox fadeAnimate(String url) throws IOException {
        VBox v = (VBox) FXMLLoader.load(getClass().getResource(url));
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(v);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        return v;
    }
    
    
    public void loadIncidente(ActionEvent event) throws IOException{
        setDataPane(fadeAnimate("/fxml/Incidente.fxml"));
    }
    
    public void loadTecnico(ActionEvent event) throws IOException{
        setDataPane(fadeAnimate("/fxml/Tecnico.fxml"));
    }
    
    
    public void salir(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText(null);
        alert.setContentText("Desea salir del sistema?");
        Optional<ButtonType>result=alert.showAndWait();
        if (result.get()==ButtonType.OK) {
            System.exit(0);
        }
    }
}
