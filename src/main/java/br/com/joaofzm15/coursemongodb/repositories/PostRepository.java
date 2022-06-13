package br.com.joaofzm15.coursemongodb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.joaofzm15.coursemongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//?0 means first parameter
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitleContainingIgnoreCaseQuery(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> findByAnywhereContainingIgnoreCaseBetweenTwoDates(String text, Date minDate, Date maxDate);
	

}
