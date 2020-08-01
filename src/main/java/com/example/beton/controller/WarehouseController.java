package com.example.beton.controller;


import com.example.beton.domain.AdminProductions;
import com.example.beton.domain.Warehouse;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WarehouseController {
    @Autowired
    private AdminProductRepo adminproductionsRepo;
    @Autowired
    private WarehouseRepo warehouseRepo;


    @GetMapping("/warehouse")
    public String showWarehouseProduct(Map<String, Object> model) {
        Iterable<Warehouse> warehouses = warehouseRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();

        model.put("warehouses", warehouses);
        model.put("adminproductions", adminproductions);
        return "warehouse";
    }

    @PostMapping("/warehouse")
    public String addWarehouseProduct(@RequestParam String warehousename, @RequestParam String warehousecount,
                                      Map<String, Object> model){

        Warehouse warehouse = new Warehouse(warehousename, warehousecount);
        warehouseRepo.save(warehouse);

        Iterable<Warehouse> warehouses = warehouseRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();

        model.put("warehouses", warehouses);
        model.put("adminproductions", adminproductions);
        return "warehouse";
    }


}
