package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.TopoCommentRepository;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.TopoComment;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopoCommentServiceImpl implements ITopoCommentService{
	
	private static final Logger log = LogManager.getLogger(TopoCommentServiceImpl.class);
	
	@Autowired
	private TopoCommentRepository topoCommentRepository;

	@Override
	public TopoComment register(String body, User author, Topo topo) throws Exception {
		
		TopoComment topoComment = new TopoComment();
		
		topoComment.setCommentBody(body);
		topoComment.setCommentAuthor(author);
		topoComment.setTopo(topo);
		
		topoComment.setCommentStatus(true);
		topoComment.setCommentDate(new Date());
		return topoCommentRepository.save(topoComment);
	}

	@Override
	public TopoComment edit(TopoComment topoComment) throws Exception {
		
		Optional<TopoComment> commentFind = topoCommentRepository.findById(topoComment.getCommentId());

		if (!commentFind.isPresent()) {

			log.error("Modification Impossible ! le topoComment " + topoComment.getCommentId() + " n'existe pas dans la base.");

			throw new Exception("Le topoComment n'existe pas !");

		}
		topoComment.setCommentDate(new Date());
		return topoCommentRepository.saveAndFlush(topoComment);
	}

	@Override
	public TopoComment getTopoComment(Long id) throws Exception {
		
		Optional<TopoComment> topoComment = topoCommentRepository.findById(id);

		if (!topoComment.isPresent()) {

			log.error("Modification Impossible ! le topoComment " + id + " n'existe pas dans la base.");

			throw new Exception("Le topoComment n'existe pas !");

		}
		return topoComment.get();
	}

	@Override
	public List<TopoComment> getAllTopoCommentS() {
		
		return topoCommentRepository.findAll();
	}
	

	@Override
	public List<TopoComment> getAllTopoCommentsByTopo(Topo topo) throws Exception {
		
		return topoCommentRepository.findByTopo(topo);
	}


}
