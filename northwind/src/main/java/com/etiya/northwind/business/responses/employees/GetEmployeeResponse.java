package com.etiya.northwind.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse {
    private int employeeId;

    private String firstName;

    private String lastName;

    private Date birthDate;
}
