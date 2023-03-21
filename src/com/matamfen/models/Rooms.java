/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matamfen.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
@Entity
@Table(name = "rooms")
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByIdrooms", query = "SELECT r FROM Rooms r WHERE r.idrooms = :idrooms"),
    @NamedQuery(name = "Rooms.findByCode", query = "SELECT r FROM Rooms r WHERE r.code = :code"),
    @NamedQuery(name = "Rooms.findByTitle", query = "SELECT r FROM Rooms r WHERE r.title = :title")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrooms")
    private Integer idrooms;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rooms")
    private Collection<Programmations> programmationsCollection;

    public Rooms() {
    }

    public Rooms(Integer idrooms) {
        this.idrooms = idrooms;
    }

    public Rooms(Integer idrooms, String code) {
        this.idrooms = idrooms;
        this.code = code;
    }

    public Integer getIdrooms() {
        return idrooms;
    }

    public void setIdrooms(Integer idrooms) {
        this.idrooms = idrooms;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Programmations> getProgrammationsCollection() {
        return programmationsCollection;
    }

    public void setProgrammationsCollection(Collection<Programmations> programmationsCollection) {
        this.programmationsCollection = programmationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrooms != null ? idrooms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.idrooms == null && other.idrooms != null) || (this.idrooms != null && !this.idrooms.equals(other.idrooms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Rooms[ idrooms=" + idrooms + " ]";
    }
    
}
