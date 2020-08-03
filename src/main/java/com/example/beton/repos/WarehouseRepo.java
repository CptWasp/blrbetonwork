package com.example.beton.repos;

import com.example.beton.domain.Warehouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WarehouseRepo extends CrudRepository<Warehouse, Integer> {

    List<Warehouse> findByWarehousename(String warehousename);
    void deleteByWarehousename(String warehousename);
}
