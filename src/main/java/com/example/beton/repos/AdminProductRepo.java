package com.example.beton.repos;

import com.example.beton.domain.AdminProductions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminProductRepo extends CrudRepository<AdminProductions, Integer> {
    List<AdminProductions> findByAdminproductname(String adminproductname);
    List<AdminProductions> deleteByAdminproductname(String adminproductname);
}
