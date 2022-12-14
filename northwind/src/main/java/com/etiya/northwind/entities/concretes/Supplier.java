package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplier_id")
    private int supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
