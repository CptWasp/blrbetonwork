package com.example.beton.repos;

import com.example.beton.domain.Production;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductionRepo extends CrudRepository<Production, Integer> {
    List<Production> findByProdname(String prodname);
}
