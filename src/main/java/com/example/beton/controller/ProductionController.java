package com.example.beton.controller;

import com.example.beton.domain.AdminProductions;
import com.example.beton.domain.Message;
import com.example.beton.domain.Production;
import com.example.beton.domain.User;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.MessageRepo;
import com.example.beton.repos.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductionController {

    @Autowired
    private AdminProductRepo adminproductionsRepo;
    @Autowired
    private ProductionRepo productionRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }



    @GetMapping("/production")
    public String main(Map<String, Object> model){
        Iterable<Production> productions = productionRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();
        model.put("adminproductions", adminproductions);
        model.put("productions", productions);
        return "production";
    }



    @PostMapping("/production")
    public String addProduction(@AuthenticationPrincipal User user, @RequestParam String productdate,
                                @RequestParam String prodname,
                                @RequestParam String prodcount, @RequestParam String mencount,
                                Map<String, Object> model){
        Production production = new Production(productdate, prodname, prodcount, mencount, user);
        productionRepo.save(production);

        Iterable<Production> productions = productionRepo.findAll();
        Iterable<AdminProductions> adminproductions = adminproductionsRepo.findAll();

        model.put("productions", productions);
        model.put("adminproductions", adminproductions);
        return "production";
    }


}