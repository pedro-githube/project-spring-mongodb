package com.spring.program.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.spring.program.domain.Post;
import com.spring.program.domain.User;
import com.spring.program.dto.AuthorDTO;
import com.spring.program.dto.CommentDTO;
import com.spring.program.repositories.PostRepository;
import com.spring.program.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("24/02/2022"), "let's trip", "i'm going to travel to boston", new AuthorDTO(maria));
	    Post post2 = new Post(null, sdf.parse("10/05/2022"), "Good Morning", "i did wake up happy today", new AuthorDTO(maria));
		
	    CommentDTO c1 = new CommentDTO("Good trip !", sdf.parse("24/02/2022"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Enjoy the trip", sdf.parse("24/02/2012"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Have a Good day !", sdf.parse("10/05/2012"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
