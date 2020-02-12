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
public class UserServiceImpl implements IUserService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IUserCategoryService iUserCategoryService;

	@Override
	public User registerByDefault(String firstName, String lastName, String userName, String password) throws Exception {		
		
		User userFind = userRepository.findByUsername(userName);

		if (userFind != null) {

			log.error("Utilisateur existe déjà !");

			throw new Exception("Utilisateur existe déjà !");

		}

		// TODO check password ?

		User user = new User();
		
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserCategory(iUserCategoryService.getDefaultUserCategory());
		user.setUserDate(new Date());

		return userRepository.save(user);

	}

	@Override
	public User edit(User user) throws Exception {

		Optional<User> userFind = userRepository.findById(user.getUserId());

		if (userFind.isEmpty()) {

			log.error("Modification Impossible ! l'utilisateur " + user.getUserId() + " n'existe pas dans la base.");

			throw new Exception("Utilisateur n'existe pas !");

		}

		// TODO check password ?
		// TODO Ajouter date de modification ?

		return userRepository.saveAndFlush(user);
	}

	@Override
	public User getUser(Long id) throws Exception {

		Optional<User> userFind = userRepository.findById(id);

		if (userFind.isEmpty()) {

			log.error("Affichage Impossible ! l'utilisateur " + id + " n'existe pas dans la base.");

			throw new Exception("Utilisateur n'existe pas !");

		}

		return userFind.get();
	}

	@Override
	public Boolean sampleLogin(String userName, String password) throws Exception {

		Boolean signIn = false;
		
		User userFind = userRepository.findByUsername(userName);

		if (userFind == null) {

			log.error("L'identifiant n'existe pas !");
			throw new Exception("L'identifiant n'existe pas !");
		}

		if (userFind.getPassword().equals(password)) {
			
			signIn = true;

		}else {
			
			log.error("Mot de passe incorrect !");
			System.out.println("Alerte  : UserFind ps : "+userFind.getPassword()+" saissie : "+password);
			throw new Exception("Mot de passe incorrect !");
			
		}		
		
		System.out.println("A"+signIn);
		
		return signIn;

	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersByCategory(UserCategory UserCategory) {

		return userRepository.findByUserCategory(UserCategory);
	}

}
