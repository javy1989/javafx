/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.controller;

import com.alvarez.dao.CategoriaDao;
import com.alvarez.dao.CodigoDao;
import com.alvarez.dao.TicketDao;
import com.alvarez.entidades.Categoria;
import com.alvarez.entidades.Codigo;
import com.alvarez.entidades.Ticket;
import com.alvarez.entidades.Usuario;
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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class IncidenteController implements Initializable {
    
    @FXML
    private Text txtSolicitante;
    @FXML
    private ComboBox<Codigo> cbTipo;
    @FXML
    private ComboBox<Categoria> cbSistema;
    @FXML
    private ComboBox<Categoria> cbCategoria;
    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TableView<Ticket> tbIncidente;
    @FXML
    private TableColumn<Ticket,Date>  col_ingreso;
    @FXML
    private TableColumn<Ticket,String>  col_estado;
    @FXML
    private TableColumn<Ticket,String>  col_titulo;
    @FXML
    private TableColumn<Ticket,String>  col_descripcion;
    @FXML
    private TableColumn<Ticket,Date>  col_solucion;
    @FXML
    private TableColumn<Ticket,Usuario>  col_tecnico;
    @FXML
    private TableColumn<Ticket,String>  col_observacion;
    private SessionUsuario session;
    private CodigoDao codigoDao;
    private CategoriaDao categoriaDao;
    private TicketDao ticketDao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = SessionUsuario.getInstace();
        txtSolicitante.setText(session.getUsuario().toString());
        initCbTipo();
        initCbSistema();
        cbSistema.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Categoria> observable, Categoria oldValue, Categoria newValue) -> {
            onItemChangeCbSistema();
        });
        initColums();
        cargarTabla();
    }
    
    
    
    private void initCbTipo() {
        try {
            codigoDao = new CodigoDao();
            Map parametros = new HashMap();
            parametros.put(";where", "o.maestro.codigo=:codigo");
            parametros.put("codigo", "TIPINC");
            parametros.put(";orden", "o.nombre");
            ObservableList<Codigo> obsTipos = FXCollections.observableArrayList();
            List<Codigo> codigos = codigoDao.listaGenerica(parametros);
            for (Codigo codigo : codigos) {
                obsTipos.add(codigo);
            }
            cbTipo.setItems(obsTipos);
        } catch (ConsultarException ex) {
            Logger.getLogger(IncidenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initCbSistema() {
        try {
            categoriaDao = new CategoriaDao();
            Map parametros = new HashMap();
            parametros.put(";where", "o.padre is null and o.posicion=0");
            parametros.put(";orden", "o.nombre");
            ObservableList<Categoria> obsCat = FXCollections.observableArrayList();
            List<Categoria> sistemas = categoriaDao.listaGenerica(parametros);
            for (Categoria sistema : sistemas) {
                obsCat.add(sistema);
            }
            cbSistema.setItems(obsCat);
        } catch (ConsultarException ex) {
            Logger.getLogger(IncidenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String onItemChangeCbSistema() {
        try {
            if (cbSistema.getValue() == null) {
                return null;
            }
            
            Map parametros = new HashMap();
            parametros.put(";where", "o.padre is not null and o.padre=:padre");
            parametros.put("padre", cbSistema.getValue());
            parametros.put(";orden", "o.posicion");
            ObservableList<Categoria> obsCat = FXCollections.observableArrayList();
            List<Categoria> sistemas = categoriaDao.listaGenerica(parametros);
            for (Categoria sistema : sistemas) {
                obsCat.add(sistema);
            }
            cbCategoria.setItems(obsCat);
            return null;
        } catch (ConsultarException ex) {
            Logger.getLogger(IncidenteController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private void cargarTabla() {
        try {
            ticketDao = new TicketDao();
            Map parametros = new HashMap();
            parametros.put(";where", "o.solicitante=:solicitante and o.estado in(:es1,:es2)");
            parametros.put("solicitante", session.getUsuario());
            parametros.put("es1", EstadoTicketEnum.CR);
            parametros.put("es2", EstadoTicketEnum.AT);
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
    
    private void initColums(){
        col_ingreso.setCellValueFactory(new PropertyValueFactory<>("ingreso"));
        col_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        col_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        col_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        col_solucion.setCellValueFactory(new PropertyValueFactory<>("solucion"));
        col_tecnico.setCellValueFactory(new PropertyValueFactory<>("tecnico"));
        col_observacion.setCellValueFactory(new PropertyValueFactory<>("observacion"));
    }
    @FXML
    public String guardar() {
        if (cbTipo.getValue() == null) {
            AlertUtil.error("Seleccionar tipo");
            return null;
        }
        if (cbSistema.getValue() == null) {
            AlertUtil.error("Seleccionar sistema");
            return null;
        }
        if (cbSistema.getValue() == null) {
            AlertUtil.error("Seleccionar categoria");
            return null;
        }
        if (txtTitulo.getText()==null || txtTitulo.getText().isEmpty()) {
            AlertUtil.error("Ingresar titulo");
            return null;
        }
        if (txtDescripcion.getText()==null || txtDescripcion.getText().isEmpty()) {
            AlertUtil.error("Ingresar descripcion del problema");
            return null;
        }
        Ticket t = new Ticket();
        t.setEstado(EstadoTicketEnum.CR);
        t.setTitulo(txtTitulo.getText());
        t.setDescripcion(txtDescripcion.getText());
        t.setIngreso(new Date());
        t.setTipo(cbTipo.getValue());
        t.setCategoria(cbCategoria.getValue());
        t.setSolicitante(session.getUsuario());
        ticketDao.guardar(t);
        AlertUtil.informacion("Transaccion exitosa");
        limpiar();
        cargarTabla();
        
        return null;
    }
    private void limpiar(){
       cbTipo.setValue(null);
       cbSistema.setValue(null);
       cbCategoria.setValue(null);
       txtTitulo.setText(null);
       txtDescripcion.setText(null);
       txtSolicitante.setText(null);
    }
}
