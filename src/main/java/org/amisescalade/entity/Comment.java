package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_COMMENT",discriminatorType = DiscriminatorType.STRING,length = 3 )

public abstract class Comment implements Serializable {
	
	@Id @GeneratedValue
	private Long commentId;
	@JoinColumn(nullable=false)
	private Date commentDate;
	@Column(length = 200)
	@JoinColumn(nullable=false)
	private String commentBody;
	@JoinColumn(nullable=false)
	private Boolean commentStatus;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User commentAuthor;
	
	@ManyToOne
	private Comment subComment;
	@OneToMany(mappedBy = "subComment",fetch = FetchType.LAZY)
	private Collection<Comment> comments;
	
	public Comment() {
		super();
	}

	public Comment(Date commentDate, String commentBody, Boolean commentStatus, User commentAuthor) {
		super();
		this.commentDate = commentDate;
		this.commentBody = commentBody;
		this.commentStatus = commentStatus;
		this.commentAuthor = commentAuthor;
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
	
	
}
