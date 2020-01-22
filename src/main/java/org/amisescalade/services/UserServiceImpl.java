package org.amisescalade.services;

import java.util.Optional;

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
	
	@Override
	public User edit(User user) throws Exception {

		Optional<User> userFind = userRepository.findById(user.getUserId());
		
		if (userFind.isEmpty()) log.error("Modification Impossible ! l'utilisateur "+ user.getUserId()+" n'existe pas dans la base.");
		
		// vérification de la saisie avec Spring Validator ?
		
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public User displayOne(User user) throws Exception {
		
		Optional<User> userFind = userRepository.findById(user.getUserId());
		
		if (userFind.isEmpty()) log.error("Affichage Impossible ! l'utilisateur "+ user.getUserId()+" n'existe pas dans la base.");
			
		return user;	
	}
	
	@Override
	public void sampleLogin(User user) throws Exception {
		
		User userFind = userRepository.findByUsername(user.getUsername());
		
		if (userFind == null) log.error("Utilisateur n'existe pas !");
		
		if (userFind.getPassword() != user.getPassword()) log.error("Mot de passe incorrect !");
		
	}

}
