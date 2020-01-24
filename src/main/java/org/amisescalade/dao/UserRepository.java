package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername (String username);

	List<User> findByUserCategory(UserCategory userCategory);

}
