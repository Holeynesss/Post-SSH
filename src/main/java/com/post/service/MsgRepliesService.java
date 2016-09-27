package com.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.MsgReplies;
import com.post.repositories.MsgRepliesRepository;

@Service
public class MsgRepliesService {

	@Autowired
	MsgRepliesRepository repliesRepository;

	public MsgReplies save(MsgReplies msgReplies) {
		repliesRepository.save(msgReplies);
		return msgReplies;
	}

	public MsgReplies findReplyByRepliesId(String repliesId) {
		return repliesRepository.findReplyByRepliesId(repliesId);
	}
}
