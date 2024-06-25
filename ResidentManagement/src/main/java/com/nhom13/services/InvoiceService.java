package com.nhom13.services;

import com.nhom13.DTOs.InvoiceDTO;
import com.nhom13.DTOs.PaymentRequest;
import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public interface InvoiceService {
    void createOrUpdateInvoice (Invoice invoice);
    void deleteInvoice (int id);
    Invoice getInvoiceById (int id);
    List<Invoice> getByResidentId(int residentId);
    public void createInvoices(List<Resident> residents);
    void createMultiple(Invoice invoice, List<Integer> residentIds);
    List<Object[]> getInvoice(Map<String, String> params);

    PaymentRequest getPaymentUrl(Integer invoiceId);
}
