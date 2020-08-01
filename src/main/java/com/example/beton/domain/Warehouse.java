package com.example.beton.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String warehousename;
    private String warehousecount;

    public Warehouse() {
    }

    public Warehouse(String warehousename, String warehousecount) {
        this.warehousename = warehousename;
        this.warehousecount = warehousecount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehousename() {
        return warehousename;
    }

    public void setWarehousename(String warehousename) {
        this.warehousename = warehousename;
    }

    public String getWarehousecount() {
        return warehousecount;
    }

    public void setWarehousecount(String warehousecount) {
        this.warehousecount = warehousecount;
    }
}
