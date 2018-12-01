package com.ddlab.rnd.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="zara_userdetails")
public class ZaraUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="authority")
	private String authority;
	
//	@ManyToOne
//    @JoinColumn(name="userid")
	@ManyToOne
    @JoinColumn(name="userid")
    private ZaraUser zaraUser;
	
	public ZaraUserDetails() {
//		super();
	}


	public ZaraUserDetails(String username, String authority, ZaraUser zaraUser) {
		super();
		this.username = username;
		this.authority = authority;
		this.zaraUser = zaraUser;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public ZaraUser getZaraUser() {
		return zaraUser;
	}
	
	
	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setZaraUser(ZaraUser zaraUser) {
		this.zaraUser = zaraUser;
	}


	@Override
	public String toString() {
		return "ZaraUserDetails [id=" + id + ", username=" + username
				+ ", authority=" + authority + "]";
	}


	
	
	

}
