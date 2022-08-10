package com.etiya.northwind.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private int employeeId;

    private String firstName;

    private String lastName;

    private Date birthDate;
}
