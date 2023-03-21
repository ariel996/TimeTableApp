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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
@Entity
@Table(name = "teachers")
@NamedQueries({
    @NamedQuery(name = "Teachers.findAll", query = "SELECT t FROM Teachers t"),
    @NamedQuery(name = "Teachers.findByIdteachers", query = "SELECT t FROM Teachers t WHERE t.idteachers = :idteachers"),
    @NamedQuery(name = "Teachers.findByName", query = "SELECT t FROM Teachers t WHERE t.name = :name"),
    @NamedQuery(name = "Teachers.findBySurname", query = "SELECT t FROM Teachers t WHERE t.surname = :surname"),
    @NamedQuery(name = "Teachers.findByTelephone", query = "SELECT t FROM Teachers t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "Teachers.findByEmail", query = "SELECT t FROM Teachers t WHERE t.email = :email")})
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteachers")
    private Integer idteachers;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "teachersCollection")
    private Collection<Subjects> subjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teachers")
    private Collection<Programmations> programmationsCollection;

    public Teachers() {
    }

    public Teachers(Integer idteachers) {
        this.idteachers = idteachers;
    }

    public Teachers(Integer idteachers, String name) {
        this.idteachers = idteachers;
        this.name = name;
    }

    public Integer getIdteachers() {
        return idteachers;
    }

    public void setIdteachers(Integer idteachers) {
        this.idteachers = idteachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Subjects> getSubjectsCollection() {
        return subjectsCollection;
    }

    public void setSubjectsCollection(Collection<Subjects> subjectsCollection) {
        this.subjectsCollection = subjectsCollection;
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
        hash += (idteachers != null ? idteachers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.idteachers == null && other.idteachers != null) || (this.idteachers != null && !this.idteachers.equals(other.idteachers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Teachers[ idteachers=" + idteachers + " ]";
    }
    
}
