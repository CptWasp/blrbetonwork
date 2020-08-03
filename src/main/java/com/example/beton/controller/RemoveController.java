package com.example.beton.controller;

import com.example.beton.domain.AdminProductions;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;



@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class RemoveController {
    @Autowired
    private AdminProductRepo adminProductRepo;
    @Autowired
    private WarehouseRepo warehouseRepo;



    @GetMapping("/removeproduct")
    public String remPage(Map<String, Object> model){
        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();
        model.put("adminproductions", adminproductions);
        return "removeproduct";
    }


    @PostMapping("/removeproduct")
    public String removeAdminProduct(@RequestParam String removname, Map<String, Object> model){


        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();
        model.put("adminproductions", adminproductions);
        return "removeproduct";
    }




}
