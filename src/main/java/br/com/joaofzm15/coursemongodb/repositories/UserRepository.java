package br.com.joaofzm15.coursemongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.joaofzm15.coursemongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
