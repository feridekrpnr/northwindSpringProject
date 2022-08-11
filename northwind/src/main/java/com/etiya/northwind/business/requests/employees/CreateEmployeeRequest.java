package com.etiya.northwind.business.requests.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private int employeeId;

    private String firstName;

    private String lastName;
    @PastOrPresent
    private Date birthDate;

    private int reportsTo;
}
