package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name="countries")
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name="country_id")
    private int countryId;

    @Column(name = "country_name" )
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<Supplier> suppliers;

    @OneToMany(mappedBy = "country")
    private List<Customer> customers;

    @OneToMany(mappedBy = "country")
    private List<Employee> employees;
}
