package com.springboot.first.app.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springboot.first.app.entity.Post;
import com.springboot.first.app.entity.UserTbl;
import com.springboot.first.app.repository.PostRepository;
import com.springboot.first.app.service.PostService;
import com.springboot.first.app.service.UserService;
import com.springboot.first.app.service.security.UserDetailsImpl;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> findPostsByUserTbl(UserTbl userTbl) {
		// TODO Auto-generated method stub
		return postRepository.findPostsByUserTbl(userTbl);
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return postRepository.findById(postId);
	}

	@Override
	public Post updatePost(Post post) {
		UserDetailsImpl userDetail = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		post.setUserTbl(userDetail.getUserTbl());
		return postRepository.save(post);
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		postRepository.deleteById(postId);
	}
}
