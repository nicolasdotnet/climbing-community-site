package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername (String username);

	List<User> findByRole(Role userCategory);

}
