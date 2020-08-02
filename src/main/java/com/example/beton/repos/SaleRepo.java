package com.example.beton.repos;

import com.example.beton.domain.Sales;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepo extends CrudRepository<Sales, Integer> {

    List<Sales> findBySalename(String salename);
}
