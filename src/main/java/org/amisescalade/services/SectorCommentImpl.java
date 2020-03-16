package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SectorCommentRepository;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectorCommentImpl implements ISectorCommentService{
	
private static final Logger log = LogManager.getLogger(SectorCommentImpl.class);
	
	@Autowired
	private SectorCommentRepository sectorCommentRepository;

	@Override
	public SectorComment register(String body, User author, Sector sector) throws Exception {
		
		SectorComment sectorComment = new SectorComment();
		
		sectorComment.setCommentBody(body);
		sectorComment.setCommentAuthor(author);
		sectorComment.setSector(sector);;
		
		sectorComment.setCommentStatus(true);
		sectorComment.setCommentDate(new Date());
		
		return sectorCommentRepository.save(sectorComment);
	}

	@Override
	public SectorComment edit(SectorComment sectorComment) throws Exception {
		
		Optional<SectorComment> commentFind = sectorCommentRepository.findById(sectorComment.getCommentId());

		if (!commentFind.isPresent()) {

			log.error("Modification Impossible ! le sectorComment " + sectorComment.getCommentId() + " n'existe pas dans la base.");

			throw new Exception("Le sectorComment n'existe pas !");

		}
		sectorComment.setCommentDate(new Date());
		return sectorCommentRepository.saveAndFlush(sectorComment);
	}

	@Override
	public SectorComment getSectorComment(Long id) throws Exception {
		
		Optional<SectorComment> sectorComment = sectorCommentRepository.findById(id);

		if (!sectorComment.isPresent()) {

			log.error("Modification Impossible ! le sectorComment " + id + " n'existe pas dans la base.");

			throw new Exception("Le sectorComment n'existe pas !");

		}
		return sectorComment.get();
	}

	@Override
	public List<SectorComment> getAllSectorComments() {
		
		return sectorCommentRepository.findAll();
	}
	

	@Override
	public List<SectorComment> getCommentBySector(Sector sector) throws Exception {
		
		return sectorCommentRepository.findBySector(sector);
	}

}
