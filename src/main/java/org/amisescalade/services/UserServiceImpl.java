package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
			
			throw new Exception("Utilisateur existe déjà !");

		}
		
		user.setUserDate(new Date());
		
		return userRepository.save(user);
		
	}
	
	@Override
	public User edit(User user) throws Exception {

		Optional<User> userFind = userRepository.findById(user.getUserId());
		
		if (userFind.isEmpty()) {
			
			log.error("Modification Impossible ! l'utilisateur "+ user.getUserId()+" n'existe pas dans la base.");
		
			throw new Exception("Utilisateur n'existe pas !");
		
		}
		
		// vérification de la saisie avec Spring Validator ?
		
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public User displayOne(User user) throws Exception {
		
		Optional<User> userFind = userRepository.findById(user.getUserId());
		
		if (userFind.isEmpty()) {
			
			log.error("Affichage Impossible ! l'utilisateur "+ user.getUserId()+" n'existe pas dans la base.");
			
			throw new Exception("Utilisateur n'existe pas !");
			
		}
			
		return user;	
	}
	
	@Override
	public void sampleLogin(User user) throws Exception {
		
		User userFind = userRepository.findByUsername(user.getUsername());
		
		if (userFind == null) { 
			
			log.error("L'identifiant n'existe pas !");
			throw new Exception("L'identifiant n'existe pas !");
		
		};
		
		if (userFind.getPassword() != user.getPassword()) { 
			
			log.error("Mot de passe incorrect !");
			throw new Exception("Mot de passe incorrect !");
			
		}
		
	}

	@Override
	public List<User> displayAll() {
		
		return userRepository.findAll();
	}

	@Override
	public List<User> displayByCategory(UserCategory UserCategory) {		
		
		return userRepository.findByUserCategory(UserCategory);
	}

}
