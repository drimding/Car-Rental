package org.dreamcatcher.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by drimcatcher on 06.06.2016.
 */
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private java.sql.Date rentDate;
    @Column(nullable = false)
    private java.sql.Date returnDate;
    @Column(nullable=false, columnDefinition="boolean default false")
    private boolean rentalClose;
    @JoinColumn(nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Car car;
    @JoinColumn(nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Client  client;

    public Rental() {
    }

    public Rental(Calendar rentDate, Calendar returnDate, boolean rentalClose, Car car, Client client) {
        this.rentDate = new java.sql.Date(rentDate.getTimeInMillis());
        this.returnDate = new java.sql.Date(returnDate.getTimeInMillis());
        this.rentalClose = rentalClose;
        this.car = car;
        this.client = client;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isRentalClose() {
        return rentalClose;
    }

    public void setRentalClose(boolean rentalClose) {
        this.rentalClose = rentalClose;
    }
}
