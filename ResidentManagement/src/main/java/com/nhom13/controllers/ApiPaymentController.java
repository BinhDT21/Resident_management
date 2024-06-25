package com.nhom13.controllers;

import com.nhom13.DTOs.PaymentRequest;
import com.nhom13.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiPaymentController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/payment/{invoiceId}")
    public ResponseEntity<PaymentRequest> getPaymentUrl(@PathVariable Integer invoiceId) {
        return ResponseEntity.ok(invoiceService.getPaymentUrl(invoiceId));
    }
}
