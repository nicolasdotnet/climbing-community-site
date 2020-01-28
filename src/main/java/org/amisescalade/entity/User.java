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
 * User is the registration entity of a community user.
 *
 */
@Entity
public class User implements Serializable{


	@Id @GeneratedValue
	private Long userId;
	@JoinColumn(nullable=false)
	private Date userDate;
	@Column(length = 100, nullable = false)
	private String firstname;
	@Column(length = 100, nullable=false)
	private String lastname;
	@Column(length = 50, nullable=false)
	private String username;
	
	// encodage du mot de passe (ds un Spring Bean) avec Spring Security ?
	@Column(length = 150, nullable=false)
	private String password;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private UserCategory userCategory;
	
	@OneToMany(mappedBy = "topoOwner",fetch = FetchType.LAZY)
	private Collection<Topo> topos;
	
	@OneToMany(mappedBy = "bookingUser",fetch = FetchType.LAZY)
	private Collection<Booking> booking;
	
	@OneToMany(mappedBy = "webpageAuthor",fetch = FetchType.LAZY)
	private Collection<Webpage> Webpage;
	
	@OneToMany(mappedBy = "commentAuthor",fetch = FetchType.LAZY)
	private Collection<Comment> comments;
	
	
	public User() {
		super();
	}
	
	


	public User(Date userDate, String firstname, String lastname, String username, String password,UserCategory userCategory) {
		super();
		this.userDate = userDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userCategory = userCategory;
	}




	public User(Date userDate, String firstname, String lastname, String username, String password,
			UserCategory userCategory, Collection<Topo> topos, Collection<Booking> booking,
			Collection<Webpage> webpage, Collection<Comment> comments) {
		super();
		this.userDate = userDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userCategory = userCategory;
		this.topos = topos;
		this.booking = booking;
		Webpage = webpage;
		this.comments = comments;
	}


	public User(Long userId, Date userDate, String username) {
		super();
		this.userId = userId;
		this.userDate = userDate;
		this.username = username;
	}




	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Date getUserDate() {
		return userDate;
	}


	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserCategory getUserCategory() {
		return userCategory;
	}


	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}


	public Collection<Topo> getTopos() {
		return topos;
	}


	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}


	public Collection<Booking> getBooking() {
		return booking;
	}


	public void setBooking(Collection<Booking> booking) {
		this.booking = booking;
	}


	public Collection<Webpage> getWebpage() {
		return Webpage;
	}


	public void setWebpage(Collection<Webpage> webpage) {
		Webpage = webpage;
	}


	public Collection<Comment> getComment() {
		return comments;
	}


	public void setComment(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "User [userDate=" + userDate + ", userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username +", UserCategory="+ userCategory +"]";
	}
	
	

}
