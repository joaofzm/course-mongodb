package br.com.joaofzm15.coursemongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.coursemongodb.domain.Post;
import br.com.joaofzm15.coursemongodb.repositories.PostRepository;
import br.com.joaofzm15.coursemongodb.resources.util.URLDecoder;
import br.com.joaofzm15.coursemongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}


	public List<Post> findByTitleContainingIgnoreCase(String text) {
		text = URLDecoder.decodeParam(text);
		return repository.findByTitleContainingIgnoreCaseQuery(text);
	}
	
	public List<Post> findByAnywhereContainingIgnoreCaseBetweenTwoDates(String text, String minDate, String maxDate) {
		text = URLDecoder.decodeParam(text);
		Date min = URLDecoder.convertDate(minDate, new Date(0L));
		Date max = URLDecoder.convertDate(maxDate, new Date());
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return repository.findByAnywhereContainingIgnoreCaseBetweenTwoDates(text, min, max);
	}
	
}
