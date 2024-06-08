package com.nhom13.services.impl;

import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;
import com.nhom13.repositories.InvoiceRepository;
import com.nhom13.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Resident> getDetailInvoiceForResident(Map<String, String> params) {
        return this.invoiceRepository.getDetailInvoiceForResident(params);
    }


    @Override
    public void createOrUpdateInvoice(Invoice invoice) { this.invoiceRepository.createOrUpdateInvoice(invoice); }

    @Override
    public void deleteInvoice(int id) {
        this.invoiceRepository.deleteInvoice(id);
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return this.invoiceRepository.getInvoiceById(id);
    }

    @Override
    public List<Invoice> getByResidentId(int residentId) {
        return invoiceRepository.getByResidentId(residentId);
    }
}
