package org.amisescalade.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author nicolasdotnet
 * 
 * UserCategoryImpl a is the category entity to which users in the community can belong :
 * Author, Climber, Moderator ...
 *
 */

@Entity

public class Role implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Author, Climber, moderator,
	
	@Id @GeneratedValue
	private Long userCategoryId;
	@Column(nullable=false)
	private Date userCategoryDate;
	@Column(length = 100, nullable=false)
	private String userCategoryLabel;
	
	@OneToMany(mappedBy="userCategory",fetch=FetchType.LAZY)
	private Collection<User> users;
	
	public Role() {
		super();
	}

	public Long getUserCategoryId() {
		return userCategoryId;
	}

	public void setUserCategoryId(Long userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	public Date getUserCategoryDate() {
		return userCategoryDate;
	}

	public void setUserCategoryDate(Date userCategoryDate) {
		this.userCategoryDate = userCategoryDate;
	}

	public String getUserCategoryLabel() {
		return userCategoryLabel;
	}

	public void setUserCategoryLabel(String userCategoryLabel) {
		this.userCategoryLabel = userCategoryLabel;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	
	@Override
	public String toString() {
		return "UserCategory [userCategoryLabel=" + userCategoryLabel + "]";
	}
	

}
