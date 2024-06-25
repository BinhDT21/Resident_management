package com.nhom13.controllers;

import com.nhom13.DTOs.InvoiceDTO;
import com.nhom13.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiInvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @DeleteMapping("/invoice-residents/{residentId}/invoices/{invoiceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable(value = "invoiceId") int invoiceId) {
        this.invoiceService.deleteInvoice(invoiceId);
    }

    @GetMapping(value = "/invoices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices(@RequestParam Map<String, String> params) {
        List<Object[]> invoices = this.invoiceService.getInvoice(params);
        List<InvoiceDTO> dtoList = new ArrayList<>();
        for (Object[] obj : invoices ) {
            Integer invoiceId = (Integer) obj[0];
            String invoiceName = (String) obj[1];
            Long amount = (Long) obj[2];
            Date dueDate = (Date) obj[3];
            String status = (String) obj[4];
            String paymentProve = (String) obj[5];
            String lastName = (String) obj[6];
            String firstName = (String) obj[7];
            Date creationDate = (Date) obj[8];

            InvoiceDTO dto = new InvoiceDTO(invoiceId, invoiceName, amount, dueDate, status, paymentProve, firstName, lastName, creationDate);
            dtoList.add(dto);
        }
        if (invoices.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}