package com.nhom13.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class InvoiceDTO {
    private int id;
    private String name;
    private long amount;
    private LocalDate dueDate;
    private String status;
    private String paymentProve;
    private int residentId;
    private String lastName;
    private String firstName;
    private Date createdDate;

    public InvoiceDTO(
            int id,
            String name,
            long amount,
            LocalDate dueDate,
            String status,
            String paymentProve,
            String lastName,
            String firstName,
            Date createdDate
    ) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
        this.paymentProve = paymentProve;
        this.lastName = lastName;
        this.firstName = firstName;
        this.createdDate = createdDate;
    }
}
