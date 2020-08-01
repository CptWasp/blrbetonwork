package com.example.beton.repos;

import com.example.beton.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Integer>  {
}
