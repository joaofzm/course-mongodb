package br.com.joaofzm15.coursemongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.joaofzm15.coursemongodb.domain.Post;
import br.com.joaofzm15.coursemongodb.domain.User;
import br.com.joaofzm15.coursemongodb.dtos.AuthorDTO;
import br.com.joaofzm15.coursemongodb.repositories.PostRepository;
import br.com.joaofzm15.coursemongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		//Must save users before creating the posts, so they persist in memory and can be referenced
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2004"), "Partiu Academia","Ta saíndo da jaula o monstro!", new AuthorDTO(alex));
		Post post2 = new Post(null, sdf.parse("22/03/2005"), "Fora Waldemar","Time sem vergonha!", new AuthorDTO(bob));
		Post post3 = new Post(null, sdf.parse("22/03/2006"), "Diretoria Jim Carrey","Osvaldo vai comandar pelo telefone!", new AuthorDTO(bob));
		Post post4 = new Post(null, sdf.parse("23/03/2008"), "Meowh","Mingau ficou feliz com a ração :)", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1,post2,post3,post4));
		
		alex.getPosts().addAll(Arrays.asList(post1));
		bob.getPosts().addAll(Arrays.asList(post2));
		bob.getPosts().addAll(Arrays.asList(post3));
		maria.getPosts().addAll(Arrays.asList(post4));
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

	}


}
