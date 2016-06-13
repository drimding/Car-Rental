package org.dreamcatcher.dto;

import java.util.Date;

/**
 * Created by drimcatcher on 09.06.2016.
 */
public class RentalList {
    private Integer id;
    private Date  rentDate;
    private Date  returnDate;
    private boolean rentalClose;
    private String car;
    private String carType;
    private String client;

    public  RentalList()
    {}
    public RentalList(Integer id, Date rentDate, Date  returnDate, boolean rentalClose, String car, String client, String carType) {
        this.id=id;
        this.rentDate=rentDate;
        this.returnDate=returnDate;
        this.rentalClose=rentalClose;
        this.car=car;
        this.client=client;
        this.carType=carType;
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

    public boolean isRentalClose() {
        return rentalClose;
    }

    public void setRentalClose(boolean rentalClose) {
        this.rentalClose = rentalClose;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }


    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "RentalList{" +
                "id=" + id +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", rentalClose=" + rentalClose +
                ", car='" + car + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
