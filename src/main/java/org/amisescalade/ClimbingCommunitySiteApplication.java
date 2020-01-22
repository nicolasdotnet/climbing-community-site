package org.amisescalade;

import java.util.Date;

import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClimbingCommunitySiteApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(ClimbingCommunitySiteApplication.class, args);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		UserCategoryRepository UserCategoryRepository = ctx.getBean(UserCategoryRepository.class);
		
		UserCategory uc1 = UserCategoryRepository.save(new UserCategory(new Date(), "grimpeur"));
		
		userRepository.save(new User(new Date(), "nicolas", "desdevises", "nico", "123", uc1));
		
		userRepository.findAll().forEach(u->System.out.println(">>>>>>>>>>>>>>>>> : "+u.getUsername()+" : "+u.getUserCategory()));
		
		
		
		
	}

}
