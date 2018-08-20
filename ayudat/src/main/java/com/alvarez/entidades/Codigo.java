/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(catalog = "ayuda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigo.findAll", query = "SELECT c FROM Codigo c")})
public class Codigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(length = 45)
    private String nombre;
    @Size(max = 45)
    @Column(length = 45)
    private String codigo;
    @Size(max = 45)
    @Column(length = 45)
    private String descripcion;
    @Size(max = 45)
    @Column(length = 45)
    private String parametros;
    @JoinColumn(name = "maestro", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Maestro maestro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.EAGER)
    private List<GrupoUsuario> grupoUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo", fetch = FetchType.EAGER)
    private List<GrupoUsuario> grupoUsuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo", fetch = FetchType.EAGER)
    private List<Ticket> ticketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuente", fetch = FetchType.EAGER)
    private List<Ticket> ticketList1;

    public Codigo() {
    }

    public Codigo(String nombre) {
        this.nombre = nombre;
    }

    
    public Codigo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList() {
        return grupoUsuarioList;
    }

    public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
        this.grupoUsuarioList = grupoUsuarioList;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList1() {
        return grupoUsuarioList1;
    }

    public void setGrupoUsuarioList1(List<GrupoUsuario> grupoUsuarioList1) {
        this.grupoUsuarioList1 = grupoUsuarioList1;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<Ticket> getTicketList1() {
        return ticketList1;
    }

    public void setTicketList1(List<Ticket> ticketList1) {
        this.ticketList1 = ticketList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigo)) {
            return false;
        }
        Codigo other = (Codigo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
