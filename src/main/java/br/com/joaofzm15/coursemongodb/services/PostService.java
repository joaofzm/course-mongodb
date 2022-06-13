package br.com.joaofzm15.coursemongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.coursemongodb.domain.Post;
import br.com.joaofzm15.coursemongodb.repositories.PostRepository;
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
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
