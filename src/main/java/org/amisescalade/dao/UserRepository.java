package org.amisescalade.dao;

import java.util.List;
import java.util.Optional;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername (String username);
        
        Optional<User> findByUsernameContainingIgnoreCase (String username);
        
        List<User> findAllByUsernameContainingIgnoreCase (String username);

	List<User> findByRole(Role userCategory);

}
