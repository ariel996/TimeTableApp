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
@Table(name = "days")
@NamedQueries({
    @NamedQuery(name = "Days.findAll", query = "SELECT d FROM Days d"),
    @NamedQuery(name = "Days.findByIddays", query = "SELECT d FROM Days d WHERE d.iddays = :iddays"),
    @NamedQuery(name = "Days.findByTitle", query = "SELECT d FROM Days d WHERE d.title = :title")})
public class Days implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddays")
    private Integer iddays;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "days")
    private Collection<Programmations> programmationsCollection;

    public Days() {
    }

    public Days(Integer iddays) {
        this.iddays = iddays;
    }

    public Days(Integer iddays, String title) {
        this.iddays = iddays;
        this.title = title;
    }

    public Integer getIddays() {
        return iddays;
    }

    public void setIddays(Integer iddays) {
        this.iddays = iddays;
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
        hash += (iddays != null ? iddays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Days)) {
            return false;
        }
        Days other = (Days) object;
        if ((this.iddays == null && other.iddays != null) || (this.iddays != null && !this.iddays.equals(other.iddays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Days[ iddays=" + iddays + " ]";
    }
    
}
