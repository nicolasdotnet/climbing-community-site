package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SpotCommentRepository;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpotCommentImpl implements ISpotCommentService{
	
	private static final Logger log = LogManager.getLogger(SpotCommentImpl.class);
	
	
	@Autowired
	private SpotCommentRepository spotCommentRepository;

	@Override
	public SpotComment register(SpotComment spotComment) throws Exception {
		
		spotComment.setCommentDate(new Date());
		return spotCommentRepository.save(spotComment);
	}

	@Override
	public SpotComment edit(SpotComment spotComment) throws Exception {
		
		Optional<SpotComment> commentFind = spotCommentRepository.findById(spotComment.getCommentId());

		if (commentFind.isEmpty()) {

			log.error("Modification Impossible ! le spotComment " + spotComment.getCommentId() + " n'existe pas dans la base.");

			throw new Exception("Le spotComment n'existe pas !");

		}
		spotComment.setCommentDate(new Date());
		return spotCommentRepository.saveAndFlush(spotComment);
	}

	@Override
	public SpotComment displayOne(Long id) throws Exception {
		
		Optional<SpotComment> spotComment = spotCommentRepository.findById(id);

		if (spotComment.isEmpty()) {

			log.error("Modification Impossible ! le spotComment " + id + " n'existe pas dans la base.");

			throw new Exception("Le spotComment n'existe pas !");

		}
		return spotComment.get();
	}

	@Override
	public List<SpotComment> displayAll() {
		
		return spotCommentRepository.findAll();
	}
	

	@Override
	public List<SpotComment> displayBySpot(Spot spot) throws Exception {
		
		return spotCommentRepository.findBySpot(spot);
	}

	
	

}
