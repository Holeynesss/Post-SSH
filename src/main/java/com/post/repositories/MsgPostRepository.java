package com.post.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.post.entity.MsgPost;
import com.post.entity.MsgReplies;

public interface MsgPostRepository extends
		JpaRepository<MsgPost, Serializable>,
		CrudRepository<MsgPost, Serializable>,
		Repository<MsgPost, Serializable>,
		PagingAndSortingRepository<MsgPost, Serializable> {
	@Query("select msgPost from MsgPost msgPost where postId = ?1")
	MsgPost findByPostId(String postId);

	List<MsgPost> findAll();

	List<MsgPost> findByUsername(String username);

	/*
	 * 按条件关键字 or 标题 or 发帖人查询
	 */
	@Query("select msgPost from MsgPost msgPost where keyWords like ?1")
	List<MsgPost> findByKeyWord(String keyWord);

	@Query("select msgPost from MsgPost msgPost where postTitle like ?1")
	List<MsgPost> findByPostTitle(String postTitle);

	@Query("select msgPost from MsgPost msgPost where postUsername like ?1")
	List<MsgPost> findByPostUsername(String postUsername);

	MsgPost save(MsgPost msgPost);

	void delete(MsgPost msgPost);

	/*
	 * @Query("delete from MsgPost msgPost where msgPost.postId = 'Hello'") void
	 * deleteMsgPost();
	 */

	@Query("select replies from MsgPost msgPost where msgPost.postId = ?1")
	List<MsgReplies> findRepliesByPostId(String postId);



}
