package br.com.joaofzm15.coursemongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.coursemongodb.domain.Post;
import br.com.joaofzm15.coursemongodb.resources.util.URLDecoder;
import br.com.joaofzm15.coursemongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByTitleContainingIgnoreCase(@RequestParam(value="text", defaultValue="") String text) {
		text = URLDecoder.decodeParam(text);
		List<Post> list = service.findByTitleContainingIgnoreCase(text);
		return ResponseEntity.ok().body(list);
	}

}
