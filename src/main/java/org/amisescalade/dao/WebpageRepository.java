package org.amisescalade.dao;

import org.amisescalade.entity.Webpage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebpageRepository extends JpaRepository<Webpage, Long>{

	Webpage findByWebpageTitle(String webpageTitle);

}
