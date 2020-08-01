package com.example.beton.controller;

import com.example.beton.domain.SettingThePrice;
import com.example.beton.repos.SettingThePriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SettingThePriceController {
    @Autowired
    private SettingThePriceRepo settingThePriceRepo;

    @GetMapping("/pricesettings")
    public String main(Map<String, Object> model){
        Iterable<SettingThePrice> pricesettings = settingThePriceRepo.findAll();

        model.put("pricesettings", pricesettings);
        return "pricesettings";
    }



    @PostMapping("/pricesettings")
    public String addNewPriceSettings(
            @RequestParam String pricedate, @RequestParam String wireprice,
            @RequestParam String armatureprice, @RequestParam String gridprice,
            @RequestParam String betonprice, Map<String, Object> model){
        SettingThePrice pricesetting = new SettingThePrice(pricedate, wireprice, armatureprice, gridprice, betonprice);

        settingThePriceRepo.save(pricesetting);
        Iterable<SettingThePrice> pricesettings = settingThePriceRepo.findAll();
        model.put("pricesettings", pricesettings);
        return "pricesettings";
    }

}
