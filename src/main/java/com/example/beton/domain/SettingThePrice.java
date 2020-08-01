package com.example.beton.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SettingThePrice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id; //раздел удержания цен

    private String wireprice;
    private String armatureprice;
    private String gridprice;
    private String betonprice;
    private String pricedate;


    public SettingThePrice() {
    }

    public SettingThePrice(String pricedate, String wireprice, String armatureprice,
                           String gridprice, String betonprice) {
        this.wireprice = wireprice;
        this.armatureprice = armatureprice;
        this.gridprice = gridprice;
        this.betonprice = betonprice;
        this.pricedate = pricedate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWireprice() {
        return wireprice;
    }

    public void setWireprice(String wireprice) {
        this.wireprice = wireprice;
    }

    public String getArmatureprice() {
        return armatureprice;
    }

    public void setArmatureprice(String armatureprice) {
        this.armatureprice = armatureprice;
    }

    public String getGridprice() {
        return gridprice;
    }

    public void setGridprice(String gridprice) {
        this.gridprice = gridprice;
    }

    public String getBetonprice() {
        return betonprice;
    }

    public void setBetonprice(String betonprice) {
        this.betonprice = betonprice;
    }

    public String getPricedate() {
        return pricedate;
    }

    public void setPricedate(String pricedate) {
        this.pricedate = pricedate;
    }
}
