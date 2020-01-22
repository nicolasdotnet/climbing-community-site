package org.amisescalade.dao;

import org.amisescalade.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Commentrepository extends JpaRepository<Comment, Long>{

}
