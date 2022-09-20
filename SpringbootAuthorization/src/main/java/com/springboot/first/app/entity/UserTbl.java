package com.springboot.first.app.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the UserTbl database table.
 * 
 */
@Entity
@NamedQuery(name="UserTbl.findAll", query="SELECT u FROM UserTbl u")
public class UserTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private String password;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="userTbl")
	private List<Post> posts = new ArrayList<>();

	//bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="User_Role"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	public UserTbl() {
	}
	
	public UserTbl(int userId, String password, String userName, List<Post> posts, List<Role> roles) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.posts = posts;
		this.roles = roles;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setUserTbl(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setUserTbl(null);

		return post;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}