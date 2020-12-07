/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrental22;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tiaro
 */
@Entity
@Table(name = "car_rental")
@NamedQueries({
    @NamedQuery(name = "CarRental.findAll", query = "SELECT c FROM CarRental c"),
    @NamedQuery(name = "CarRental.findById", query = "SELECT c FROM CarRental c WHERE c.id = :id"),
    @NamedQuery(name = "CarRental.findByStartDate", query = "SELECT c FROM CarRental c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "CarRental.findByDaysAmount", query = "SELECT c FROM CarRental c WHERE c.daysAmount = :daysAmount"),
    @NamedQuery(name = "CarRental.findByPrice", query = "SELECT c FROM CarRental c WHERE c.price = :price")})
public class CarRental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "daysAmount")
    private int daysAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Car carId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User clientId;

    public CarRental() {
    }

    public CarRental(Integer id) {
        this.id = id;
    }

    public CarRental(Integer id, Date startDate, int daysAmount, int price) {
        this.id = id;
        this.startDate = startDate;
        this.daysAmount = daysAmount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(int daysAmount) {
        this.daysAmount = daysAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public User getClientId() {
        return clientId;
    }

    public void setClientId(User clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof CarRental)) {
            return false;
        }
        CarRental other = (CarRental) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.carrental22.CarRental[ id=" + id + " ]";
    }
    
}
