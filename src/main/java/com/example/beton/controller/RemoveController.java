package com.example.beton.controller;

import com.example.beton.domain.AdminProductions;
import com.example.beton.domain.Warehouse;
import com.example.beton.repos.AdminProductRepo;
import com.example.beton.repos.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;




//@PreAuthorize("hasAuthority('ADMIN')")
@Service
@Controller
public class RemoveController {
    @Autowired
    private AdminProductRepo adminProductRepo;
    @Autowired
    private WarehouseRepo warehouseRepo;



    @GetMapping("/removeproduct")
    public String remPage(Map<String, Object> model){
        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();

        for (AdminProductions ap : adminproductions){
            System.out.println(ap.getAdminproductname());
        }

        model.put("adminproductions", adminproductions);
        return "removeproduct";
    }

    @Transactional
    @PostMapping("/removeproduct")
    public String removeAdminProduct(@RequestParam String removname, Map<String, Object> model){
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println(removname);

//        Удаление из рецептов админки
        List<AdminProductions> adp = adminProductRepo.findByAdminproductname(removname);
        for(AdminProductions ad : adp){
            adminProductRepo.deleteById(ad.getId());
            System.out.println(ad.getId() +" : "+ad.getAdminproductname());
        }
//        Удаление из склада
        warehouseRepo.deleteByWarehousename(removname);

        Iterable<AdminProductions> adminproductions = adminProductRepo.findAll();
        model.put("adminproductions", adminproductions);
        return "removeproduct";
    }




}
