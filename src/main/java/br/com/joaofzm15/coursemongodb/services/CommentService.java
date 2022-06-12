package br.com.joaofzm15.coursemongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.coursemongodb.domain.Comment;
import br.com.joaofzm15.coursemongodb.domain.Post;
import br.com.joaofzm15.coursemongodb.domain.User;
import br.com.joaofzm15.coursemongodb.repositories.CommentRepository;
import br.com.joaofzm15.coursemongodb.repositories.PostRepository;
import br.com.joaofzm15.coursemongodb.services.exceptions.ObjectNotFoundException;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;
	
	public List<Comment> findAll(){
		return repository.findAll();
	}
	
	public Comment findById(String id) {
		Optional<Comment> comment = repository.findById(id);
		return comment.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}


}
