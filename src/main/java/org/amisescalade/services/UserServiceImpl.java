package org.amisescalade.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import static org.amisescalade.security.EncrytedPasswordUtils.encrytePassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleService iUserCategoryService;

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
        user.setPassword(encrytePassword(password));
        user.setUserCategory(iUserCategoryService.getDefaultUserCategory());
        user.setUserDate(new Date());

        return userRepository.save(user);

    }

    @Override
    public User uploadProfile(MultipartFile file, int userId) throws Exception {

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters

            Optional<User> userFind = userRepository.findById(Long.valueOf(userId));

            if (!userFind.isPresent()) {

                log.error("Modification Impossible ! l'utilisateur " + userId + " n'existe pas dans la base.");

                throw new Exception("Utilisateur n'existe pas !");

            }

            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            userFind.get().setProfile(file.getBytes());

            return userRepository.saveAndFlush(userFind.get());
            
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public User edit(User user) throws Exception {

        Optional<User> userFind = userRepository.findById(user.getUserId());

        if (!userFind.isPresent()) {

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

        if (!userFind.isPresent()) {

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

        } else {

            log.error("Mot de passe incorrect !");
            System.out.println("Alerte  : UserFind ps : " + userFind.getPassword() + " saissie : " + password);
            throw new Exception("Mot de passe incorrect !");

        }

        System.out.println("A" + signIn);

        return signIn;

    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByCategory(Role UserCategory) {

        return userRepository.findByUserCategory(UserCategory);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Objects.requireNonNull(username);
        
               User userFind = userRepository.findByUsername(username);

        if (userFind == null) {

            log.error("L'identifiant n'existe pas !");
            throw new UsernameNotFoundException("L'identifiant n'existe pas !");
        }
        
        return userFind;
    }

}
