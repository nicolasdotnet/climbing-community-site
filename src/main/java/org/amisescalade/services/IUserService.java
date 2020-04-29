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
     * @param username
     * @return user object modified
     * @throws Exception
     */
    User uploadProfile(MultipartFile file, String username) throws Exception;

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
     * @param username
     */
    public void delete(String username)throws Exception;

    /**
     * method to desactivate a user
     *
     * @param userId
     * @throws java.lang.Exception
     */
    public void desactivate(Long userId) throws Exception;

    /**
     * method to get all users by username
     *
     * @param userName
     * @return the list users with the username
     * @throws java.lang.Exception
     */
    public List<User> getAllUserByUsername(String userName) throws Exception;

    /**
     * method to update password
     *
     * @param passwordNew
     * @param username
     * @return user objet update
     * @throws java.lang.Exception
     */
    public User updatePassword(String passwordNew, String username) throws Exception;

}
