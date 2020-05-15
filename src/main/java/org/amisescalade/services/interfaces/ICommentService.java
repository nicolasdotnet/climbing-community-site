package org.amisescalade.services.interfaces;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.Comment;

public interface ICommentService {

    /**
     * method to register a Comment
     *
     * @param body
     * @param username
     * @param spotId
     * @return Comment object saved
     * @throws Exception
     */
    Comment register(String body, String username, Long spotId) throws Exception;

    /**
     * method to modify a Comment
     *
     * @param comment
     * @return Comment object modified
     * @throws Exception
     */
    Comment edit(Comment comment) throws Exception;

    /**
     * method to delete a Comment
     *
     * @param commentId
     * @throws Exception
     */
    void delete(Long commentId) throws Exception;

    /**
     * method to get a Comment by his id
     *
     * @param commentId
     * @return Comment object
     * @throws Exception
     */
    Comment getComment(Long commentId) throws Exception;

    /**
     * method to get all Comments
     *
     * @return the Comment list
     */
    List<Comment> getAllComments();

    /**
     * method to get all Comments by his spot
     *
     * @param spot
     * @return the Comment list with his spot
     * @throws Exception
     */
    List<Comment> getAllCommentBySpot(Spot spot) throws Exception;

}
