package com.example.beton.controller;

import com.example.beton.domain.Production;
import com.example.beton.domain.Sales;
import com.example.beton.domain.User;
import com.example.beton.repos.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SalesController {
    @Autowired
    private SaleRepo saleRepo;



    @GetMapping("/sales")
    public String main(Map<String, Object> model){
        Iterable<Sales> sales = saleRepo.findAll();
        model.put("sales", sales);
        return "sales";
    }



    @PostMapping("/sales")
    public String addProduction(@AuthenticationPrincipal User user, @RequestParam String saledate,
                                @RequestParam String salename,
                                @RequestParam String saletotal, @RequestParam String salecount,
                                Map<String, Object> model){
        Sales sale = new Sales(saledate, salename, saletotal, salecount, user);
        saleRepo.save(sale);

        Iterable<Sales> sales = saleRepo.findAll();
        model.put("sales", sales);

        return "sales";
    }



}
