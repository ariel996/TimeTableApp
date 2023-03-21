/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matamfen.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
@Entity
@Table(name = "programmations")
@NamedQueries({
    @NamedQuery(name = "Programmations.findAll", query = "SELECT p FROM Programmations p"),
    @NamedQuery(name = "Programmations.findByTeachersIdteachers", query = "SELECT p FROM Programmations p WHERE p.programmationsPK.teachersIdteachers = :teachersIdteachers"),
    @NamedQuery(name = "Programmations.findByRoomsIdrooms", query = "SELECT p FROM Programmations p WHERE p.programmationsPK.roomsIdrooms = :roomsIdrooms"),
    @NamedQuery(name = "Programmations.findByDaysIddays", query = "SELECT p FROM Programmations p WHERE p.programmationsPK.daysIddays = :daysIddays")})
public class Programmations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgrammationsPK programmationsPK;
    @JoinColumn(name = "days_iddays", referencedColumnName = "iddays", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Days days;
    @JoinColumn(name = "rooms_idrooms", referencedColumnName = "idrooms", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rooms rooms;
    @JoinColumn(name = "subjects_idsubjects", referencedColumnName = "idsubjects")
    @ManyToOne(optional = false)
    private Subjects subjectsIdsubjects;
    @JoinColumn(name = "teachers_idteachers", referencedColumnName = "idteachers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teachers teachers;
    @JoinColumn(name = "times_idtimes", referencedColumnName = "idtimes")
    @ManyToOne(optional = false)
    private Times timesIdtimes;

    public Programmations() {
    }

    public Programmations(ProgrammationsPK programmationsPK) {
        this.programmationsPK = programmationsPK;
    }

    public Programmations(int teachersIdteachers, int roomsIdrooms, int daysIddays) {
        this.programmationsPK = new ProgrammationsPK(teachersIdteachers, roomsIdrooms, daysIddays);
    }

    public ProgrammationsPK getProgrammationsPK() {
        return programmationsPK;
    }

    public void setProgrammationsPK(ProgrammationsPK programmationsPK) {
        this.programmationsPK = programmationsPK;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Subjects getSubjectsIdsubjects() {
        return subjectsIdsubjects;
    }

    public void setSubjectsIdsubjects(Subjects subjectsIdsubjects) {
        this.subjectsIdsubjects = subjectsIdsubjects;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public Times getTimesIdtimes() {
        return timesIdtimes;
    }

    public void setTimesIdtimes(Times timesIdtimes) {
        this.timesIdtimes = timesIdtimes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programmationsPK != null ? programmationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmations)) {
            return false;
        }
        Programmations other = (Programmations) object;
        if ((this.programmationsPK == null && other.programmationsPK != null) || (this.programmationsPK != null && !this.programmationsPK.equals(other.programmationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.Programmations[ programmationsPK=" + programmationsPK + " ]";
    }
    
}
