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
        String[] adminProductArray = new String[1000];
//        массив количества производимых товаров
        Integer[] prices = new Integer[1000];
//        массив проданных товаров
        Integer[] salecount = new Integer[1000];
//        массив цен на проданные изделия
        Double[] saletotal = new Double[1000];
//        массив параметров использования бетона
        Double[] btncount = new Double[1000];
//        массив параметров использования арматуры
        Double[] armaturecount = new Double[1000];
//        массив параметров использования проволоки
        Double[] wirecount = new Double[1000];
//        массив параметров использования сетки
        Double[] gridcount = new Double[1000];
//        Сумма всех продаж
        Double reportsumm = 0.0;

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
//                System.out.println(ad +" : "+ prCount);
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
//                System.out.println(sp +" : "+ slCount);
                j++;
            }
        }

//        общая сумма
//        for (Double summ : saletotal) {
//            reportsumm += summ;
//            System.out.println(summ+":"+reportsumm);
//        }

//        Получение цен на проданные товары
        Integer foo = 0;
        for (String st : adminProductArray) {
            Double stCount = 0.0;

            if (st!=null){
                Iterable<Sales> salestotal = saleRepo.findBySalename(st);

                for (Sales slt : salestotal) {
                    stCount += Double.parseDouble(slt.getSaletotal());
                }
                saletotal[foo] = stCount*salecount[foo];
                reportsumm+=stCount*salecount[foo];
//                System.out.println(st +" : "+ stCount);
                foo++;
            }
        }

//        Получение использования количества бетон
//        Получение использования количества арматуры
//        Получение использования количества проволки
//        Получение использования количества сетки
        Integer b_count = 0;
        Iterable<AdminProductions> beton_w = adminProductRepo.findAll();
        for (AdminProductions bt_w : beton_w){
            btncount[b_count] = Double.parseDouble(bt_w.getAdminproductbeton())*salecount[b_count];
            armaturecount[b_count] = Double.parseDouble(bt_w.getAdminproductarmature())*salecount[b_count];
            wirecount[b_count] = Double.parseDouble(bt_w.getAdminproductwire())*salecount[b_count];
            gridcount[b_count] = Double.parseDouble(bt_w.getAdminproductgrid())*salecount[b_count];
            System.out.println(adminProductArray[b_count]+"=> Сделано:"+prices[b_count]+"=> продано:"+
                    salecount[b_count]+"=> в руб:"+saletotal+"=>  бетон:"+btncount[b_count]+"=> арматура:"+
                    armaturecount[b_count]+"=> проволока:"+
                    wirecount[b_count]+"=> сетка:"+gridcount[b_count]);
            b_count++;
        }





        model.put("ad", adminProductArray);
        model.put("prc", prices);
        model.put("slcnts", salecount);
        model.put("sattls", saletotal);
        model.put("btnwghts", btncount);
        model.put("armwghts", armaturecount);
        model.put("wirewghts", wirecount);
        model.put("gridwghts", gridcount);
        model.put("reportsumm", reportsumm);


        return "report";
    }


    @GetMapping("/reportsuper")
    public String superShowReport(Map<String, Object> model){


        return "superreport";
    }




}
