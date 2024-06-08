package com.nhom13.services;

import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;

import java.util.List;
import java.util.Map;

public interface InvoiceService {
    List<Resident> getDetailInvoiceForResident(Map<String, String> params);
    void createOrUpdateInvoice (Invoice invoice);
    void deleteInvoice (int id);
    Invoice getInvoiceById (int id);
    List<Invoice> getByResidentId(int residentId);
}
