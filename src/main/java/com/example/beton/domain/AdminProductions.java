package com.example.beton.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminProductions {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String adminproductname;
    private String adminproductbeton;
    private String adminproductwire;
    private String adminproductarmature;
    private String adminproductgrid;
    private String adminproducttotal;

    public AdminProductions() {
    }

    public AdminProductions(String adminproductname, String adminproductbeton,
                            String adminproductwire, String adminproductarmature,
                            String adminproductgrid, String adminproducttotal) {
        this.adminproductname = adminproductname;
        this.adminproductbeton = adminproductbeton;
        this.adminproductwire = adminproductwire;
        this.adminproductarmature = adminproductarmature;
        this.adminproductgrid = adminproductgrid;
        this.adminproducttotal = adminproducttotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminproductname() {
        return adminproductname;
    }

    public void setAdminproductname(String adminproductname) {
        this.adminproductname = adminproductname;
    }

    public String getAdminproductbeton() {
        return adminproductbeton;
    }

    public void setAdminproductbeton(String adminproductbeton) {
        this.adminproductbeton = adminproductbeton;
    }

    public String getAdminproductwire() {
        return adminproductwire;
    }

    public void setAdminproductwire(String adminproductwire) {
        this.adminproductwire = adminproductwire;
    }

    public String getAdminproductarmature() {
        return adminproductarmature;
    }

    public void setAdminproductarmature(String adminproductarmature) {
        this.adminproductarmature = adminproductarmature;
    }

    public String getAdminproductgrid() {
        return adminproductgrid;
    }

    public void setAdminproductgrid(String adminproductgrid) {
        this.adminproductgrid = adminproductgrid;
    }

    public String getAdminproducttotal() {
        return adminproducttotal;
    }

    public void setAdminproducttotal(String adminproducttotal) {
        this.adminproducttotal = adminproducttotal;
    }
}
