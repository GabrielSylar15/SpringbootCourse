package com.springboot.first.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.springboot.first.app.entity.Post;
import com.springboot.first.app.repository.PostRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.first.app.service.PostService;
import com.springboot.first.app.service.security.UserDetailsImpl;

@RestController
public class PostController {
	@Autowired
	private PostService postService;

	@GetMapping("/api/post/list")
	public List<Post> listPosts() {
		return postService.getAllPost();
	}

	@PostMapping("/api/post/add")
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		post.setUserTbl(userDetails.getUserTbl());
		return ResponseEntity.ok(postService.updatePost(post));
	}

//	Chưa xong/	
	@PutMapping("/api/post/edit/{id}")
	@PreAuthorize("returnObject.getBody().getUserTbl().getUserName() == authentication.principal.userTbl.userName")
	public ResponseEntity<Post> editPost(@RequestBody Post post) {
		return ResponseEntity.ok(postService.updatePost(post));
	}

	@DeleteMapping("/api/post/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") int postId) {
		postService.deletePost(postId);
		return new ResponseEntity<String>("Delete successfully", HttpStatus.OK);
	}

	@GetMapping("/api/post/mypost")
	public ResponseEntity<List<Post>> getMyPosts() {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return ResponseEntity.ok(postService.findPostsByUserTbl(userDetails.getUserTbl()));
	}
}
