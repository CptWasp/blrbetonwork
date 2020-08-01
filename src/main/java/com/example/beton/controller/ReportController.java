package com.example.beton.controller;

import com.example.beton.domain.Production;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.ProductionRepo;
import com.example.beton.repos.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {
    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private AdminProductRepo adminProductRepo;

    @Autowired
    private ProductionRepo productionRepo;

    @GetMapping("/report")
    public String getShowReports(Map<String, Object> model){
//        Количество произведенных подуктов


//        model.put("productioncounts", productioncounts);

        return "report";
    }

}
