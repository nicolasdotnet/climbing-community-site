package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 *
 * Comment is the registration entity of a user comment.
 *
 */

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private Long commentId;
    @Column(nullable = false)
    private Date commentDate;
    @Column(nullable = false)
    private String commentBody;
    @Column(nullable = false)
    private Boolean commentStatus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User commentAuthor;

    @ManyToOne
    private Comment subComment;
    
    @OneToMany(mappedBy = "subComment", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    @ManyToOne
    private Spot spot;

    public Comment() {
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Boolean getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public User getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(User commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public Comment getSubComment() {
        return subComment;
    }

    public void setSubComment(Comment subComment) {
        this.subComment = subComment;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
    
    

}
