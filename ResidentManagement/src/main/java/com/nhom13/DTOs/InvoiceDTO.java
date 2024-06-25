package com.nhom13.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ejb.Local;
import java.util.Date;

@Getter
@Setter
public class InvoiceDTO {
    private int id;
    private String name;
    private long amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date dueDate;
    private String status;
    private String paymentProve;
    private int residentId;
    private String lastName;
    private String firstName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date createdDate;

    public InvoiceDTO(
            int id,
            String name,
            long amount,
            Date dueDate,
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
