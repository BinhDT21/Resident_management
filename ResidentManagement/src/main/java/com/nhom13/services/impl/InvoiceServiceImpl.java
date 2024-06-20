package com.nhom13.services.impl;

import com.nhom13.DTOs.InvoiceDTO;
import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;
import com.nhom13.repositories.InvoiceRepository;
import com.nhom13.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public void createInvoices(List<Resident> residents) {
        invoiceRepository.createInvoices(residents);
    }

    @Override
    public void createMultiple(Invoice invoice, List<Integer> residentIds) {
        List<Invoice> invoices = residentIds.stream().map(r -> {
            Invoice i = new Invoice();
            i.setName(invoice.getName());
            i.setAmount(invoice.getAmount());
            i.setDueDate(invoice.getDueDate());
            i.setCreatedDate(new Date());
            i.setResidentId(new Resident(r));
            i.setStatus("unpaid");
            return i;
        }).collect(Collectors.toList());
        invoiceRepository.createMultiple(invoices);
    }

    @Override
    public List<Object[]> getInvoice(Map<String, String> params) {
        return this.invoiceRepository.getInvoice(params);
    }
}
