package org.dreamcatcher.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by drimcatcher on 06.06.2016.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String address;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "client")
    private List<Rental> rental;

    public Client(){}
    public Client(String name){
        this.name=name;

    }
    public Client(String name, String address){
        this(name);
        this.address=address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Rental> getRental() {
        return rental;
    }

    public void setRental(List<Rental> rental) {
        this.rental = rental;
    }
}
