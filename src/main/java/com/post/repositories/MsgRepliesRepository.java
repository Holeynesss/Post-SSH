package com.post.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.post.entity.MsgReplies;

public interface MsgRepliesRepository extends
		JpaRepository<MsgReplies, Serializable>,
		CrudRepository<MsgReplies, Serializable> {
	MsgReplies save(MsgReplies msgReplies);

	@Query("select msgReplies from MsgReplies msgReplies where repliesId = ?1")
	MsgReplies findReplyByRepliesId(String repliesId);
}
