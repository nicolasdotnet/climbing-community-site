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
 * Webpage is the registration entity of a classic web page.
 *
 */
@Entity
public class Webpage implements Serializable {
	
	@Id @GeneratedValue
	private Long webpageId;
	@Column(nullable=false)
	private Date webpageDate;
	@Column(length = 500, nullable=false)
	private String webpageTitle;
	private String webpageBody;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User webpageAuthor;
	
	@OneToMany(mappedBy = "webpage",fetch = FetchType.LAZY)
	private Collection<WebpageComment>webpageComments;
	
	public Webpage() {
		super();
	}
	
	

	public Webpage(Date webpageDate, String webpageTitle, String webpageBody, User webpageAuthor) {
		super();
		this.webpageDate = webpageDate;
		this.webpageTitle = webpageTitle;
		this.webpageBody = webpageBody;
		this.webpageAuthor = webpageAuthor;
	}



	public Webpage(Date webpageDate, String webpageTitle, String webpageBody, User webpageAuthor,
			Collection<WebpageComment> webpageComments) {
		super();
		this.webpageDate = webpageDate;
		this.webpageTitle = webpageTitle;
		this.webpageBody = webpageBody;
		this.webpageAuthor = webpageAuthor;
		this.webpageComments = webpageComments;
	}

	public Long getWebpageId() {
		return webpageId;
	}

	public void setWebpageId(Long webpageId) {
		this.webpageId = webpageId;
	}

	public Date getWebpageDate() {
		return webpageDate;
	}

	public void setWebpageDate(Date webpageDate) {
		this.webpageDate = webpageDate;
	}

	public String getWebpageTitle() {
		return webpageTitle;
	}

	public void setWebpageTitle(String webpageTitle) {
		this.webpageTitle = webpageTitle;
	}

	public String getWebpageBody() {
		return webpageBody;
	}

	public void setWebpageBody(String webpageBody) {
		this.webpageBody = webpageBody;
	}

	public User getWebpageAuthor() {
		return webpageAuthor;
	}

	public void setWebpageAuthor(User webpageAuthor) {
		this.webpageAuthor = webpageAuthor;
	}

	public Collection<WebpageComment> getWebpageComment() {
		return webpageComments;
	}

	public void setWebpageComment(Collection<WebpageComment> webpageComments) {
		this.webpageComments = webpageComments;
	}



	@Override
	public String toString() {
		return "Webpage [webpageDate=" + webpageDate + ", webpageTitle=" + webpageTitle + ", webpageBody=" + webpageBody
				+ ", webpageAuthor=" + webpageAuthor + "]";
	}
	
	
	
	
	
	

}
