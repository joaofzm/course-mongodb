package br.com.joaofzm15.coursemongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.coursemongodb.domain.Comment;
import br.com.joaofzm15.coursemongodb.dtos.CommentDTO;
import br.com.joaofzm15.coursemongodb.dtos.UserDTO;
import br.com.joaofzm15.coursemongodb.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {
	
	@Autowired
	CommentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CommentDTO>> findAll(){
		List<Comment> list = service.findAll();
		List<CommentDTO> listDto = list.stream().map(x -> new CommentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Comment> findById(@PathVariable String id){
		Comment commment = service.findById(id);
		return ResponseEntity.ok().body(commment);
	}

}
