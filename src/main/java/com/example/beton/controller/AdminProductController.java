package com.example.beton.controller;

import com.example.beton.domain.AdminProductions;
import com.example.beton.domain.Sales;
import com.example.beton.domain.Warehouse;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminProductController {
    @Autowired
    private AdminProductRepo adminProductRepo;
    @Autowired WarehouseRepo warehouseRepo;


    @GetMapping("/adminproductions")
    public String main(Map<String, Object> model){
        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();
        model.put("adminproductions", adminproductions);
        return "adminproducts";
    }


    @PostMapping("/adminproductions")
    public String addAdminProductions(
            @RequestParam String adminproductname, @RequestParam String adminproductbeton,
            @RequestParam String adminproductwire, @RequestParam String adminproductarmature,
            @RequestParam String adminproductgrid, @RequestParam String adminproducttotal,  Map<String, Object> model){

        AdminProductions adminproduction = new AdminProductions(adminproductname, adminproductbeton,
                adminproductwire, adminproductarmature, adminproductgrid, adminproducttotal);
        adminProductRepo.save(adminproduction);

//        Создаем такое изделие на складе

        Warehouse warehouse = new Warehouse(adminproductname, "0");
        warehouseRepo.save(warehouse);

        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();
        model.put("adminproductions", adminproductions);


        return "adminproducts";
    }


}
