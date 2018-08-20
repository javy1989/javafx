/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.controller;


import com.alvarez.dao.TicketDao;
import com.alvarez.entidades.Categoria;
import com.alvarez.entidades.Codigo;
import com.alvarez.entidades.Ticket;
import com.alvarez.enumeradores.EstadoTicketEnum;
import com.alvarez.excepciones.ConsultarException;
import com.alvarez.util.AlertUtil;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class TecnicoController implements Initializable {
    
    @FXML
    private Text txtSolicitante;
    
    @FXML
    private ComboBox<Codigo> cbTipo;
    @FXML
    private ComboBox<Categoria> cbSistema;
    @FXML
    private ComboBox<Categoria> cbCategoria;
    @FXML
    private TextArea txtSolucion;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TableView<Ticket> tbIncidente;
    @FXML
    private TableColumn<Ticket, Date> col_ingreso;
    @FXML
    private TableColumn<Ticket, String> col_estado;
    @FXML
    private TableColumn<Ticket, String> col_titulo;
    @FXML
    private TableColumn<Ticket, String> col_descripcion;
    
    private SessionUsuario session;
    
    private TicketDao ticketDao;
    private Ticket ticketSeleccionado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        session = SessionUsuario.getInstace();
        initColums();
        cargarTabla();
        tbIncidente.setOnMousePressed((MouseEvent event) -> {
            selectTicket(tbIncidente.getSelectionModel().getSelectedItem());
        });
    }
    
    private void cargarTabla() {
        try {
            ticketDao = new TicketDao();
            Map parametros = new HashMap();
            parametros.put(";where", "o.estado in(:es1,:es2)");
            parametros.put("es1", EstadoTicketEnum.CR);
            parametros.put("es2", EstadoTicketEnum.ES);
            parametros.put(";orden", "o.ingreso");
            ObservableList<Ticket> dtTicket = FXCollections.observableArrayList();
            List<Ticket> tickets = ticketDao.listaGenerica(parametros);
            for (Ticket ticket : tickets) {
                dtTicket.add(ticket);
            }
            
            tbIncidente.setItems(dtTicket);
        } catch (ConsultarException ex) {
            Logger.getLogger(IncidenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initColums() {
        col_ingreso.setCellValueFactory(new PropertyValueFactory<>("ingreso"));
        col_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        col_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    }
    
    private void selectTicket(Ticket t) {
        this.ticketSeleccionado = t;
        cbTipo.setValue(t.getTipo());
        cbSistema.setValue(t.getCategoria().getPadre());
        cbCategoria.setValue(t.getCategoria());
        txtSolicitante.setText(t.getSolicitante().toString());
        txtTitulo.setText(t.getTitulo());
        txtDescripcion.setText(t.getDescripcion());
        
    }
    
    @FXML
    private String atender() {
        if (ticketSeleccionado == null) {
            AlertUtil.error("Seleccionar un ticket");
            return null;
        }
        if (txtSolucion.getText() == null || txtSolucion.getText().trim().isEmpty()) {
            AlertUtil.error("Ingresar una descripcion de solucion");
            return null;
        }
        ticketSeleccionado.setSolucion(new Date());
        ticketSeleccionado.setObservacion(txtSolucion.getText());
        ticketSeleccionado.setEstado(EstadoTicketEnum.AT);
        ticketSeleccionado.setTecnico(session.getUsuario());
        ticketDao=new TicketDao();
        ticketDao.modificar(ticketSeleccionado);
        AlertUtil.informacion("Transaccion exitosa");
        cargarTabla();
        limpiar();
        return null;
    }
    
    private void limpiar() {
        cbTipo.setValue(null);
        cbSistema.setValue(null);
        cbCategoria.setValue(null);
        txtTitulo.setText(null);
        txtDescripcion.setText(null);
        txtSolucion.setText(null);
        txtSolicitante.setText(null);
    }
}
