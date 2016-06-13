package org.dreamcatcher.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by drimcatcher on 06.06.2016.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String type;
    @Column(nullable=false, columnDefinition="boolean default false")
    private boolean nowRent;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="car")
    private List<Rental> rental;

    public Car() {}
    public Car(String name) {
        this.name=name;
    }
    public Car(String name, String type) {
        this(name);
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Rental> getRental() {
        return rental;
    }

    public void setRental(List<Rental> rental) {
        this.rental = rental;
    }

    public boolean isNowRent() {
        return nowRent;
    }

    public void setNowRent(boolean nowRent) {
        this.nowRent = nowRent;
    }
}
