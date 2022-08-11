package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Supplier> suppliers;

    @OneToMany(mappedBy="city")
    private List<Customer> customers;

    @OneToMany(mappedBy = "city")
    private List<Employee> employees;
}
