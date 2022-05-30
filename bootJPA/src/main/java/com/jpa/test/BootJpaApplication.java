package com.jpa.test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;


@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext r =  SpringApplication.run(BootJpaApplication.class, args);
		
		UserRepository userRepository =  r.getBean(UserRepository.class);
//		User u = new User();
//		u.setName("sam");
//		u.setCity("mumbai");
//	
//		User user = userRepository.save(u);   // Create User
//		System.out.println(user);
//		
//		userRepository.delete(user);      // delete
		
		System.out.println(userRepository.findAll()); // get All
		 
		Optional<User> i = userRepository.findById(3);  // get by id
		User o = i.get();
		System.out.println(o);
		
		o.setName("ram");  // Update it
		userRepository.save(o);
		
		
		Iterable<User> uAll =  userRepository.findAll();
		
		uAll.forEach(new Consumer<User>() {
			@Override
			public void accept(User t) {
				System.out.println(t);
			}
		
		});
		
		List<User> p = (List<User>) userRepository.findAll();
		System.out.println(p);
		
		uAll.forEach(u->System.out.println(u.getName()));
		
		
		System.out.println("fwahg" + userRepository.findByName("ram"));
		
		System.out.println(userRepository.getAllUser());
		
		System.out.println(userRepository.getUserByName("ram"));
		
	}

}
