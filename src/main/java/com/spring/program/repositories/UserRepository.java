package com.spring.program.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.program.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
