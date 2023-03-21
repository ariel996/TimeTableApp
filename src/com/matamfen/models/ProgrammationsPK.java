/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matamfen.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ariel
 */
@Embeddable
public class ProgrammationsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "teachers_idteachers")
    private int teachersIdteachers;
    @Basic(optional = false)
    @Column(name = "rooms_idrooms")
    private int roomsIdrooms;
    @Basic(optional = false)
    @Column(name = "days_iddays")
    private int daysIddays;

    public ProgrammationsPK() {
    }

    public ProgrammationsPK(int teachersIdteachers, int roomsIdrooms, int daysIddays) {
        this.teachersIdteachers = teachersIdteachers;
        this.roomsIdrooms = roomsIdrooms;
        this.daysIddays = daysIddays;
    }

    public int getTeachersIdteachers() {
        return teachersIdteachers;
    }

    public void setTeachersIdteachers(int teachersIdteachers) {
        this.teachersIdteachers = teachersIdteachers;
    }

    public int getRoomsIdrooms() {
        return roomsIdrooms;
    }

    public void setRoomsIdrooms(int roomsIdrooms) {
        this.roomsIdrooms = roomsIdrooms;
    }

    public int getDaysIddays() {
        return daysIddays;
    }

    public void setDaysIddays(int daysIddays) {
        this.daysIddays = daysIddays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) teachersIdteachers;
        hash += (int) roomsIdrooms;
        hash += (int) daysIddays;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgrammationsPK)) {
            return false;
        }
        ProgrammationsPK other = (ProgrammationsPK) object;
        if (this.teachersIdteachers != other.teachersIdteachers) {
            return false;
        }
        if (this.roomsIdrooms != other.roomsIdrooms) {
            return false;
        }
        if (this.daysIddays != other.daysIddays) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matamfen.models.ProgrammationsPK[ teachersIdteachers=" + teachersIdteachers + ", roomsIdrooms=" + roomsIdrooms + ", daysIddays=" + daysIddays + " ]";
    }
    
}
