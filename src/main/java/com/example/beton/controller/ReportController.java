package com.example.beton.controller;

import com.example.beton.domain.AdminProductions;
import com.example.beton.domain.Production;
import com.example.beton.domain.Sales;
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
//        производимые продукты
        String[] adminProductArray = new String[20];
//        массив количества производимых товаров
        Integer[] prices = new Integer[20];
//        массив проданных товаров
        Integer[] salecount = new Integer[20];

        /*##############################################*/
        /*############## сверху Массивы ################*/
        /*##############################################*/


//        Получение списка производимых продуктов
        Integer count = 0;
        Iterable<AdminProductions> adminprod = adminProductRepo.findAll();
        for (AdminProductions admprd : adminprod){
            adminProductArray[count] = admprd.getAdminproductname();
            count++;
        }

//        Получение количества производимых продуктов
        Integer i = 0;
        for (String ad : adminProductArray) {
            Integer prCount=0;

            if (ad!=null){
                Iterable<Production> prod = productionRepo.findByProdname(ad);

                for (Production pr : prod) {
                    prCount += Integer.parseInt(pr.getProdcount());
                }
                prices[i] = prCount;
                System.out.println(ad +" : "+ prCount);
                i++;
            }
        }

//        Получение количества проданных товаров
        Integer j = 0;
        for (String sp : adminProductArray) {
            Integer slCount=0;

            if (sp!=null && !sp.equals("Количество не указано")){
                Iterable<Sales> sales = saleRepo.findBySalename(sp);

                for (Sales sl : sales) {
                    slCount += Integer.parseInt(sl.getSalecount());
                }
                salecount[j] = slCount;
                System.out.println(sp +" : "+ slCount);
                j++;
            }
        }








        model.put("ad", adminProductArray);
        model.put("prc", prices);
        model.put("slcnts", salecount);

        return "report";
    }


    @GetMapping("/reportsuper")
    public String superShowReport(Map<String, Object> model){


        return "superreport";
    }




}
