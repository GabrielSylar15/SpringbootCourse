package com.springboot.first.app.service;

import java.util.List;
import java.util.Optional;

import com.springboot.first.app.entity.Post;
import com.springboot.first.app.entity.UserTbl;


public interface PostService {
	public List<Post> findPostsByUserTbl(UserTbl userTbl);
	public List<Post> getAllPost();
	public Optional<Post> getPostById(Integer postId);
	public Post updatePost(Post post);
	public void deletePost(Integer post);
}
