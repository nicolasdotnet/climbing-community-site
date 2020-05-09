package org.amisescalade.services;

import org.amisescalade.services.interfaces.ICommentService;
import org.amisescalade.services.interfaces.ISpotService;
import org.amisescalade.services.interfaces.IUserService;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.CommentRepository;
import org.amisescalade.entity.Comment;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    private static final Logger log = LogManager.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ISpotService iSpotService;

    @Override
    public Comment register(String body, String username, Long spotId) throws Exception {

        Optional<User> author = iUserService.getUserByUsername(username);

        if (!author.isPresent()) {

            log.error("Utilisateur " + username + " n'existe pas dans la base !");

            throw new Exception("Utilisateur " + username + " n'existe pas dans la base !");

        }
        
        Spot spotFind = iSpotService.getSpot(spotId);
        if (spotFind==null) {
            
            
            log.error("Le spot " + spotId + " n'existe pas dans la base !");

            throw new Exception("Le site " + spotId +  " n'existe pas dans la base !");
            
        }


        Comment comment = new Comment();

        comment.setCommentBody(body);
        comment.setCommentAuthor(author.get());
        comment.setSpot(spotFind);

        comment.setCommentStatus(true);
        comment.setCommentDate(new Date());

        return commentRepository.save(comment);
    }

    @Override
    public Comment edit(Comment comment) throws Exception {

        Optional<Comment> commentFind = commentRepository.findById(comment.getCommentId());

        if (!commentFind.isPresent()) {

            log.error("Modification Impossible ! le comment " + comment.getCommentId() + " n'existe pas dans la base.");

            throw new Exception("Le commentaire " + comment.getCommentId() + " n'existe pas !");

        }
        commentFind.get().setCommentDate(new Date());
        commentFind.get().setCommentBody(comment.getCommentBody());
        return commentRepository.saveAndFlush(commentFind.get());
    }

    @Override
    public Comment getComment(Long commentId) throws Exception {

        Optional<Comment> spotComment = commentRepository.findById(commentId);

        if (!spotComment.isPresent()) {

            log.error("Le comment " + commentId + " n'existe pas dans la base.");

            throw new Exception("Le commentaire  " + commentId + " n'existe pas !");

        }
        return spotComment.get();
    }

    @Override
    public List<Comment> getAllComments() {

        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllCommentBySpot(Spot spot) throws Exception {

        return commentRepository.findBySpot(spot);
    }

    @Override
    public void delete(Long commentId) throws Exception {
        commentRepository.deleteById(commentId);
    }

}
