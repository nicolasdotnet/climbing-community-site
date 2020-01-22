package org.amisescalade.dao;

import org.amisescalade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername (String username);

}
