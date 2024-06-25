package com.nhom13.controllers;

import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;
import com.nhom13.services.InvoiceService;
import com.nhom13.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ResidentService residentService;

    @Autowired
    private Environment env;

    @GetMapping("/invoice-residents")
    public String invoiceResidentsView(Model model, @RequestParam Map<String, String> params) {
        List<Resident> residents = residentService.getResidentWithInvoices(params);
        model.addAttribute("totalPages", params.get("totalPages"));
        model.addAttribute("currentPage", params.get("currentPage"));
        model.addAttribute("residents", residents);
        return "invoice-residents";
    }

    @GetMapping("/invoice-residents/{id}/all")
    public String getInvoiceOfUser(@PathVariable int id, @RequestParam Map<String, String> params, Model model) {
        List<Invoice> invoices = invoiceService.getByResidentId(id);
        model.addAttribute("residentId", id);
        model.addAttribute("invoices", invoices);

        return "invoice-resident-detail";
    }

    @GetMapping("/invoice-residents/{residentId}/{invoiceId}")
    public String getInvoice(@PathVariable("invoiceId") int id, Model model) {
        model.addAttribute("invoice", invoiceService.getInvoiceById(id));
        return "invoice-detail";
    }
    @GetMapping("/invoice-residents/{residentId}/create")
    public String getInvoiceCreateView(@PathVariable int residentId, Model model) {
        Invoice invoice = new Invoice();
        invoice.setResidentId(new Resident(residentId));
        invoice.setStatus("unpaid");
        model.addAttribute("invoice", invoice);
        return "invoice-detail";
    }

    @PostMapping("/invoices")
    public String createOrUpdate(@ModelAttribute Invoice invoice) {
        invoiceService.createOrUpdateInvoice(invoice);
        int residentId = invoice.getResidentId().getId();
        return "redirect:/invoice-residents/" + residentId + "/all";
    }

    @DeleteMapping("/invoice-residents/{residentId}/invoices/{invoiceId}")
    public String deleteInvoice(@PathVariable int residentId, @PathVariable int invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
        return "redirect:/invoice-residents/" + residentId + "/all";
    }

    @GetMapping("/invoices/create-multiple")
    public String createMultiple(Model model) {
        List residents = residentService.getAll();
        model.addAttribute("residents", residents);
        model.addAttribute("invoice", new Invoice());
        return "invoice-create-multiple";
    }

    @PostMapping("/invoices/create-multiple")
    public String postCreateMultiple(@ModelAttribute Invoice invoice,
                                    @RequestParam(name= "residents", required = false) List<Integer> residentIds) {
        invoiceService.createMultiple(invoice, residentIds);
        return "redirect:/invoice-residents";
    }

//    @PostMapping("invoices/create-multiple")
//    public String createInvoices(@RequestParam("residentIds[]") List<Integer> residentIds) {
//        List<Resident> residents = residentService.getUserById(residentIds)
//    }


//    @Autowired
//    private InvoiceService invoiceAdminService;
//
//    @Autowired
//    private ResidentService residentService;
//
//    @GetMapping("/invoice-residents")
//    public String createInvoiceView(@RequestParam Map<String, String> params, Model model) {
//        List<Resident> residents = residentService.getWithInvoices(params);
//        model.addAttribute("residents", residents);
//        return "invoice-residents";
//    }
//
//    @GetMapping("/invoice-residents/{id}/all")
//    public String getInvoiceOfUser(@PathVariable int id, @RequestParam Map<String, String> params, Model model) {
//        model.addAttribute("residentId", id);
//        model.addAttribute("invoices", invoiceAdminService.getByResidentId(id, params));
//        return "invoice-resident-detail";
//    }
//
//    @GetMapping("/invoice-residents/{residentId}/{invoiceId}")
//    public String getInvoice(@PathVariable("invoiceId") int id, Model model) {
//        model.addAttribute("invoice", invoiceAdminService.getInvoiceById(id));
//        return "invoice-detail";
//    }
//
//    @GetMapping("/invoice-residents/{residentId}/create")
//    public String getInvoiceCreateView(@PathVariable int residentId, Model model) {
//        Invoice invoice = new Invoice();
//        invoice.setResidentId(new Resident(residentId));
//        invoice.setStatus("unpaid");
//        model.addAttribute("invoice", invoice);
//        return "invoice-detail";
//    }
//
//    @PostMapping("/invoices")
//    public String createOrUpdate(@ModelAttribute Invoice invoice) {
//        invoiceAdminService.createOrUpdate(invoice);
//        int residentId = invoice.getResidentId().getId();
//        return "redirect:/invoice-residents/" + residentId + "/all";
//    }

}
