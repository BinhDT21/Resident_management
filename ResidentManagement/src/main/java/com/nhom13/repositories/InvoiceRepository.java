package com.nhom13.repositories;

import com.nhom13.DTOs.InvoiceDTO;
import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;

import java.util.List;
import java.util.Map;

public interface InvoiceRepository {
    void createOrUpdateInvoice (Invoice invoice);
    void deleteInvoice (int id);
    public Invoice getInvoiceById (int id);
    List<Invoice> getByResidentId(int residentId);
    public void createInvoices(List<Resident> residents);
    void createMultiple(List<Invoice> invoices);
    List<Object[]> getInvoice(Map<String, String> params);
}
