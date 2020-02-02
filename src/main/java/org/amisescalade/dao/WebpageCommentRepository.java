package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebpageCommentRepository extends JpaRepository<WebpageComment, Long> {
	
	List<WebpageComment> findByWebpage(Webpage webpage);

}
