package org.amisescalade.services;

import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) throws Exception {
		
		User userFind = userRepository.findByUsername(user.getUsername());
		
		if (userFind != null) {
			
			log.error("Utilisateur existe déjà !");
			
		}
		
		return userRepository.save(user);
		
	}
	
	
	
	

}
