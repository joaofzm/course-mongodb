package br.com.joaofzm15.coursemongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.joaofzm15.coursemongodb.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
