package com.dinamita.dinamitademo.Repository;

import com.dinamita.dinamitademo.Entity.orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ordersRepo extends CrudRepository<orders, Integer> {
}
