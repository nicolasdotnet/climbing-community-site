package org.amisescalade.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.UserRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import static org.amisescalade.security.EncrytedPasswordUtils.encrytePassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleService iUserCategoryService;

    @Override
    public User registerByDefault(String firstName, String lastName, String email, String userName, String password) throws Exception {

        User userFind = userRepository.findByUsername(userName);

        if (userFind != null) {

            log.error("Utilisateur existe déjà !");

            throw new Exception("Utilisateur existe déjà !");

        }

        User user = new User();

        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(encrytePassword(password));
        user.setRole(iUserCategoryService.getDefaultUserCategory());
        user.setEnabled(true);
        user.setUserDate(new Date());

        return userRepository.save(user);

    }

    @Override
    public User uploadProfile(MultipartFile file, String username) throws Exception {

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters

            Optional<User> userFind = userRepository.findByUsernameContainingIgnoreCase(username);

            if (!userFind.isPresent()) {

                log.error("Modification Impossible ! l'utilisateur " + username + " n'existe pas dans la base.");

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
    public ByteArrayInputStream getProfile(Long id) throws Exception {

        Optional<User> userFind = userRepository.findById(id);

        if (!userFind.isPresent()) {

            log.error("Modification Impossible ! l'utilisateur " + id + " n'existe pas dans la base.");

            throw new Exception("Utilisateur n'existe pas !");

        }

        byte[] imageBytes = userFind.get().getProfile();

        if (imageBytes == null) {

            throw new Exception("Pas de profil !");

        }

        return new ByteArrayInputStream(imageBytes);

    }

    @Override
    public User edit(User user) throws Exception {

        Optional<User> userFind = userRepository.findById(user.getUserId());

        if (!userFind.isPresent()) {

            log.error("Modification Impossible ! l'utilisateur " + user.getUserId() + " n'existe pas dans la base.");

            throw new Exception("Utilisateur n'existe pas !");

        }

        userFind.get().setFirstname(user.getFirstname());
        userFind.get().setLastname(user.getLastname());
        userFind.get().setEmail(user.getEmail());
        return userRepository.saveAndFlush(userFind.get());
    }

    @Override
    public void desactivate(Long userId) throws Exception {

        Optional<User> userFind = userRepository.findById(userId);

        if (!userFind.isPresent()) {

            log.error("Modification Impossible ! l'utilisateur " + Math.toIntExact(userId) + " n'existe pas dans la base.");

            throw new Exception("Utilisateur n'existe pas !");

        }

        userFind.get().setEnabled(false);

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
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(Role userCategory) {

        return userRepository.findByRole(userCategory);
    }

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void delete(String username) throws Exception {

        Optional<User> userFind = userRepository.findByUsernameContainingIgnoreCase(username);

        if (!userFind.isPresent()) {

            log.error("Modification Impossible ! l'utilisateur " + username + " n'existe pas dans la base.");

            throw new Exception("Utilisateur n'existe pas !");

        }

        userRepository.deleteById(userFind.get().getUserId());
    }

    @Override
    public List<User> getAllUserByUsername(String userName) throws Exception {
        return userRepository.findAllByUsernameContainingIgnoreCase(userName);
    }

    @Override
    public User updatePassword(String passwordNew, String username) throws Exception {

        Optional<User> userFind = userRepository.findByUsernameContainingIgnoreCase(username);

        if (!userFind.isPresent()) {

            log.error("Modification Impossible ! l'utilisateur " + username + " n'existe pas dans la base.");

            throw new Exception("Utilisateur n'existe pas !");

        }

        userFind.get().setPassword(encrytePassword(passwordNew));
        return userRepository.saveAndFlush(userFind.get());

    }

}
