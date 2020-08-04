package com.example.beton.controller;

import com.example.beton.domain.*;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.SaleRepo;
import com.example.beton.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SalesController {
    @Autowired
    private SaleRepo saleRepo;
    @Autowired
    private AdminProductRepo adminproductionsRepo;
    @Autowired
    private WarehouseRepo warehouseRepo;



    @GetMapping("/sales")
    public String main(Map<String, Object> model){
        Iterable<Sales> sales = saleRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();
        model.put("adminproductions", adminproductions);
        model.put("sales", sales);
        return "sales";
    }



    @PostMapping("/sales")
    public String addProduction(@AuthenticationPrincipal User user, @RequestParam String saledate,
                                @RequestParam String salename, @RequestParam String salecount,
                                Map<String, Object> model){
        Sales sale = new Sales(saledate, salename, "0", salecount, user);
        saleRepo.save(sale);

        Iterable<Sales> sales = saleRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();


        Integer whCount = 0;
        List<Warehouse> sls = warehouseRepo.findByWarehousename(salename);
        for (Warehouse sl : sls){
            whCount = Integer.parseInt(sl.getWarehousecount());
            whCount = whCount - Integer.parseInt(salecount);
            sl.setWarehousecount(whCount.toString());
            warehouseRepo.save(sl);
        }


        model.put("adminproductions", adminproductions);
        model.put("sales", sales);

        return "sales";
    }



}
