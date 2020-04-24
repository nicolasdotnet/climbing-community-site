package org.amisescalade.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService {

    /**
     * method to register a user by default
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param username
     * @param password
     *
     * @return user object saved
     * @throws Exception
     */
    User registerByDefault(String firstname, String lastname, String email, String username, String password) throws Exception;

    /**
     * method to modify a user
     *
     * @param user
     * @return user object modified
     * @throws Exception
     */
    User edit(User user) throws Exception;

    /**
     * method to upload profile a user
     *
     * @param file
     * @param userId
     * @return user object modified
     * @throws Exception
     */
    User uploadProfile(MultipartFile file, Long userId) throws Exception;

    /**
     * method to get a user
     *
     * @param userId
     * @return user object find
     * @throws Exception
     */
    ByteArrayInputStream getProfile(Long userId) throws Exception;

    /**
     * method to get a profile for a user
     *
     * @param userId
     * @return user object find
     * @throws Exception
     */
    User getUser(Long userId) throws Exception;

    /**
     * method to get all users
     *
     * @return the users list
     */
    List<User> getAllUsers();

    /**
     * method to get all users for a role
     *
     * @param UserCategory
     * @return the list users from Role label
     */
    List<User> getUsersByRole(Role UserCategory);

    /**
     * method to get a user by his username
     *
     * @param userName
     * @return the list users from Role label
     */
    public User getUserByUsername(String userName);

    /**
     * method to remove a user
     *
     * @param userId
     */
    public void delete(Long userId);

}
