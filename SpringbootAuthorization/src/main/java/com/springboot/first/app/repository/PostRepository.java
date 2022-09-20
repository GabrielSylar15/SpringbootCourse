package com.springboot.first.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.entity.Post;
import com.springboot.first.app.entity.UserTbl;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	public List<Post> findPostsByUserTbl(UserTbl userTbl);
}
