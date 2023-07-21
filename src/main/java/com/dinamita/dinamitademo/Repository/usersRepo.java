package com.dinamita.dinamitademo.Repository;

import com.dinamita.dinamitademo.Entity.users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepo extends CrudRepository<users, Integer> {
}