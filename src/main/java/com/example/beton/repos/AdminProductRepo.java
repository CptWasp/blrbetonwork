package com.example.beton.repos;

import com.example.beton.domain.AdminProductions;
import org.springframework.data.repository.CrudRepository;

public interface AdminProductRepo extends CrudRepository<AdminProductions, Integer> {
}
