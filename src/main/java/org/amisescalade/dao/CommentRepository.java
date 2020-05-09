package org.amisescalade.dao;

import java.util.List;
import org.amisescalade.entity.Comment;
import org.amisescalade.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findBySpot(Spot spot);

}
