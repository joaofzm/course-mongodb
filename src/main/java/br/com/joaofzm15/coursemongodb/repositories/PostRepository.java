package br.com.joaofzm15.coursemongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.joaofzm15.coursemongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//?0 means first parameter
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleContainingIgnoreCaseQuery(String text);
	

}
