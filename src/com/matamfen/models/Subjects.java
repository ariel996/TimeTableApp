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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "subjects")
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s"),
    @NamedQuery(name = "Subjects.findByIdsubjects", query = "SELECT s FROM Subjects s WHERE s.idsubjects = :idsubjects"),
    @NamedQuery(name = "Subjects.findByCode", query = "SELECT s FROM Subjects s WHERE s.code = :code"),
    @NamedQuery(name = "Subjects.findByName", query = "SELECT s FROM Subjects s WHERE s.name = :name")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjects")
    private Integer idsubjects;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "teachers_has_subjects", joinColumns = {
        @JoinColumn(name = "subjects_idsubjects", referencedColumnName = "idsubjects")}, inverseJoinColumns = {
        @JoinColumn(name = "teachers_idteachers", referencedColumnName = "idteachers")})
    @ManyToMany
    private Collection<Teachers> teachersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectsIdsubjects")
    private Collection<Programmations> programmationsCollection;

    public Subjects() {
    }

    public Subjects(Integer idsubjects) {
        this.idsubjects = idsubjects;
    }

    public Subjects(Integer idsubjects, String code, String name) {
        this.idsubjects = idsubjects;
        this.code = code;
        this.name = name;
    }

    public Integer getIdsubjects() {
        return idsubjects;
    }

    public void setIdsubjects(Integer idsubjects) {
        this.idsubjects = idsubjects;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Teachers> getTeachersCollection() {
        return teachersCollection;
    }

    public void setTeachersCollection(Collection<Teachers> teachersCollection) {
        this.teachersCollection = teachersCollection;
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
        hash += (idsubjects != null ? idsubjects.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.idsubjects == null && other.idsubjects != null) || (this.idsubjects != null && !this.idsubjects.equals(other.idsubjects))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Subjects[ idsubjects=" + idsubjects + " ]";
    }
    
}
