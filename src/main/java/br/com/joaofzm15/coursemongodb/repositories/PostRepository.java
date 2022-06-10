package br.com.joaofzm15.coursemongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.joaofzm15.coursemongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
