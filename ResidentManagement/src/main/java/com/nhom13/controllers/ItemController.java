package com.nhom13.controllers;

import com.nhom13.pojo.ElectronicLocker;
import com.nhom13.pojo.Item;
import com.nhom13.services.ElectronicLockerService;
import com.nhom13.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ElectronicLockerService electronicLockerService;

    @GetMapping("/electronic-lockers/{elId}/items")
    public String getAllItemByElId(@PathVariable int elId,
                                   @RequestParam Map<String, String> params, Model model) {
        ElectronicLocker el = electronicLockerService.getElectronicLockerById(elId);
        String residentName = el.getResidentId().getUserId().getLastName()
                + " " + el.getResidentId().getUserId().getFirstName();
        model.addAttribute("items", itemService.getAllItemById(elId, params));
        model.addAttribute("residentName", residentName);
        model.addAttribute("elId", elId);
        return "item";
    }

    @GetMapping("/electronic-lockers/{elId}/items/{id}")
    public String getItem(@PathVariable int id, Model model) {
        Item i = itemService.getItemById(id);
        model.addAttribute("item", i);
        model.addAttribute("elId", i.getElectronicLockerId().getId());
        return "item-detail";
    }

    @GetMapping("/electronic-lockers/{elId}/items/create")
    public String createView(@PathVariable int elId, Model model) {
        ElectronicLocker el = electronicLockerService.getElectronicLockerById(elId);
        Item i = new Item();
        i.setElectronicLockerId(el);
        model.addAttribute("item", i);
        model.addAttribute("elId", elId);
        return "item-detail";
    }

    @PostMapping("/electronic-lockers/{elId}/items/create")
    public String create(@ModelAttribute Item item, Model model) {
        itemService.updatOrCreateItem(item);
        return "redirect:/electronic-lockers/"+ item.getElectronicLockerId().getId() +"/items";
    }
}
