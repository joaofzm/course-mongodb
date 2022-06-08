package br.com.joaofzm15.coursemongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaofzm15.coursemongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	// @GettMapping would also work
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "maria@gmail.com");
		User claudio = new User("1", "Claudio", "craudio@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,claudio));
		return ResponseEntity.ok().body(list);
	}

	public UserResource() {
		// TODO Auto-generated constructor stub
	}

}
