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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class DiapazonReportController {
    @Autowired
    private AdminProductRepo adminProductRepo;

    @Autowired
    private ProductionRepo productionRepo;

    @Autowired
    private SaleRepo saleRepo;


    @GetMapping("/diapazone")
    public String showDiap(Map<String, Object> model){
        ArrayList<AdminProductions> adminProductionsArray = new ArrayList<AdminProductions>();


        ArrayList<Integer> salesArrayInteger = new ArrayList<Integer>();
        ArrayList<Double> salesArrayDouble = new ArrayList<Double>();

        ArrayList<Integer> productionArrayInteger = new ArrayList<Integer>();

        ArrayList<Integer> menArrayInteger = new ArrayList<Integer>();



//  ## ^ #########################^###
//     |   Сверху массивы данных  |
//  ##################################

//-----------
        Iterable<AdminProductions> adminProducts = adminProductRepo.findAll();
        for (AdminProductions admprdcts : adminProducts) {
            adminProductionsArray.add(admprdcts);
        }
//-----------
//-----------   Получаем общее количество произведенного материала каждого продукта

        for (AdminProductions prct : adminProductionsArray){
            Integer prCount = 0;
            Integer mnCount = 0;
            Iterable<Production> prod = productionRepo.findByProdname(prct.getAdminproductname());
                for (Production production : prod){
                    prCount += Integer.parseInt(production.getProdcount());
                    mnCount += Integer.parseInt(production.getMencount());
                }
                productionArrayInteger.add(prCount);
                menArrayInteger.add(mnCount);
        }
//-----------
//-----------   Получаем общее количество проданных изделий
        for (AdminProductions prct : adminProductionsArray){
            Integer slCount = 0;
            Double slTotal = 0.0;
            Iterable<Sales> sals = saleRepo.findBySalename(prct.getAdminproductname());
            for (Sales sales : sals){
                slCount += Integer.parseInt(sales.getSalecount());
                slTotal += Double.parseDouble(prct.getAdminproducttotal())*Integer.parseInt(sales.getSalecount());

            }
            salesArrayInteger.add(slCount);
            salesArrayDouble.add(slTotal);
        }
//-----------


        model.put("adminprdcts", adminProductionsArray);
        model.put("productionprdcts", productionArrayInteger);
        model.put("salesprdcts", salesArrayInteger);
        model.put("salesprdctstotals", salesArrayDouble);
        model.put("manprdcts", menArrayInteger);


        return "diapazone";
    }



    @PostMapping("/diapazone")
    public String showByDiapazone(@RequestParam String productdateone, @RequestParam String productdatesecond,
                                  Map<String, Object> model){

//        год #### [0], месяц ## [1], день ## [2]
        String[] productDateOneArray;
        String[] productDateSecondArray;

        String delimeter = "-"; // Разделитель
        productDateOneArray = productdateone.split(delimeter);
        productDateSecondArray = productdatesecond.split(delimeter);

        System.out.println("Введенная дата 1: ");
        System.out.println("год: " + productDateOneArray[0]);
        System.out.println("месяц: " + productDateOneArray[1]);
        System.out.println("день: " + productDateOneArray[2]);
        System.out.println("Введенная дата 2: ");
        System.out.println("год: " + productDateSecondArray[0]);
        System.out.println("месяц: " + productDateSecondArray[1]);
        System.out.println("день: " + productDateSecondArray[2]);



        ArrayList<AdminProductions> adminProductionsArray = new ArrayList<AdminProductions>();


        ArrayList<Integer> salesArrayInteger = new ArrayList<Integer>();
        ArrayList<Double> salesArrayDouble = new ArrayList<Double>();
        ArrayList<Integer> productionArrayInteger = new ArrayList<Integer>();
        ArrayList<Integer> menArrayInteger = new ArrayList<Integer>();



//  ## ^ #########################^###
//     |   Сверху массивы данных  |
//  ##################################

//-----------
        Iterable<AdminProductions> adminProducts = adminProductRepo.findAll();
        for (AdminProductions admprdcts : adminProducts) {
            adminProductionsArray.add(admprdcts);
        }
//-----------
//-----------   Получаем общее количество произведенного материала каждого продукта

        for (AdminProductions prct : adminProductionsArray){
            Integer prCount = 0;
            Integer mnCount = 0;
            Iterable<Production> prod = productionRepo.findByProdname(prct.getAdminproductname());
            for (Production production : prod){
            String[] productionDateArray = production.getProductdate().split(delimeter);

                System.out.println("дата изделия: ");
                System.out.println("год: " + productionDateArray[0]);
                System.out.println("месяц: " + productionDateArray[1]);
                System.out.println("день: " + productionDateArray[2]);






                if (Integer.parseInt(productionDateArray[0])>=Integer.parseInt(productDateOneArray[0])&&
                    Integer.parseInt(productionDateArray[1])>=Integer.parseInt(productDateOneArray[1])&&
                    Integer.parseInt(productionDateArray[2])>=Integer.parseInt(productDateOneArray[2])&&

                    Integer.parseInt(productionDateArray[0])<=Integer.parseInt(productDateSecondArray[0])&&
                    Integer.parseInt(productionDateArray[1])<=Integer.parseInt(productDateSecondArray[1])&&
                    Integer.parseInt(productionDateArray[2])<=Integer.parseInt(productDateSecondArray[2])
                ) {

                    prCount += Integer.parseInt(production.getProdcount());
                    mnCount += Integer.parseInt(production.getMencount());


                }
            }
            productionArrayInteger.add(prCount);
            menArrayInteger.add(mnCount);
        }
//-----------
//-----------   Получаем общее количество проданных изделий
        for (AdminProductions prct : adminProductionsArray){
            Integer slCount = 0;
            Double slTotal = 0.0;
            Iterable<Sales> sals = saleRepo.findBySalename(prct.getAdminproductname());
            for (Sales sales : sals){
                String[] salesDateArray = sales.getSaledate().split(delimeter);
                if (Integer.parseInt(salesDateArray[0])>=Integer.parseInt(productDateOneArray[0])&&
                        Integer.parseInt(salesDateArray[1])>=Integer.parseInt(productDateOneArray[1])&&
                        Integer.parseInt(salesDateArray[2])>=Integer.parseInt(productDateOneArray[2])&&

                        Integer.parseInt(salesDateArray[0])<=Integer.parseInt(productDateSecondArray[0])&&
                        Integer.parseInt(salesDateArray[1])<=Integer.parseInt(productDateSecondArray[1])&&
                        Integer.parseInt(salesDateArray[2])<=Integer.parseInt(productDateSecondArray[2])
                ) {
                    slCount += Integer.parseInt(sales.getSalecount());
                    slTotal += Double.parseDouble(prct.getAdminproducttotal()) * Integer.parseInt(sales.getSalecount());
                }
            }
            salesArrayInteger.add(slCount);
            salesArrayDouble.add(slTotal);
        }
//-----------


        model.put("adminprdcts", adminProductionsArray);
        model.put("productionprdcts", productionArrayInteger);
        model.put("salesprdcts", salesArrayInteger);
        model.put("salesprdctstotals", salesArrayDouble);
        model.put("manprdcts", menArrayInteger);

        return "diapazone";
    }







}
