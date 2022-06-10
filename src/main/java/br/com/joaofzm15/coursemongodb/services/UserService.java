package br.com.joaofzm15.coursemongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaofzm15.coursemongodb.domain.User;
import br.com.joaofzm15.coursemongodb.dtos.UserDTO;
import br.com.joaofzm15.coursemongodb.repositories.UserRepository;
import br.com.joaofzm15.coursemongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		//By searching the id first, the system will throw 
		//an exception in case it don't exist, just like it would if we were just searching an id normally.
		findById(id);
		repository.deleteById(id);
	}

	public User returnUserFromUserDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}

}
