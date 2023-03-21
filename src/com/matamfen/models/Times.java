/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matamfen.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ariel
 */
@Entity
@Table(name = "times")
@NamedQueries({
    @NamedQuery(name = "Times.findAll", query = "SELECT t FROM Times t"),
    @NamedQuery(name = "Times.findByIdtimes", query = "SELECT t FROM Times t WHERE t.idtimes = :idtimes"),
    @NamedQuery(name = "Times.findByStartTime", query = "SELECT t FROM Times t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Times.findByEndTime", query = "SELECT t FROM Times t WHERE t.endTime = :endTime")})
public class Times implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtimes")
    private Integer idtimes;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timesIdtimes")
    private Collection<Programmations> programmationsCollection;

    public Times() {
    }

    public Times(Integer idtimes) {
        this.idtimes = idtimes;
    }

    public Times(Integer idtimes, Date startTime, Date endTime) {
        this.idtimes = idtimes;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getIdtimes() {
        return idtimes;
    }

    public void setIdtimes(Integer idtimes) {
        this.idtimes = idtimes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        hash += (idtimes != null ? idtimes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Times)) {
            return false;
        }
        Times other = (Times) object;
        if ((this.idtimes == null && other.idtimes != null) || (this.idtimes != null && !this.idtimes.equals(other.idtimes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Times[ idtimes=" + idtimes + " ]";
    }
    
}
