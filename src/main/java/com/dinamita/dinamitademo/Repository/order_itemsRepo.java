package com.dinamita.dinamitademo.Repository;

import com.dinamita.dinamitademo.Entity.order_items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface order_itemsRepo extends CrudRepository<order_items, Integer> {
}
