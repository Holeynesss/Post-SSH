package com.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.post.entity.MsgPost;
import com.post.entity.MsgReplies;
import com.post.repositories.MsgPostRepository;

@Service
public class MsgPostService {
	@Autowired
	private MsgPostRepository msgPostRepository;

	public List<MsgPost> findAll() {
		return msgPostRepository.findAll();
	}

	public Page<MsgPost> page(int pn, int ps) {
		Page<MsgPost> posts = msgPostRepository.findAll(new PageRequest(pn, ps));
		return posts;
	}

	public List<MsgPost> findByKeyWord(String keyWord) {
		return msgPostRepository.findByKeyWord(keyWord);
	}

	public List<MsgPost> findByPostUsername(String postUsername) {
		return msgPostRepository.findByPostUsername(postUsername);
	}

	public List<MsgPost> findByPostTitle(String postTitle) {
		return msgPostRepository.findByPostTitle(postTitle);
	}

	public MsgPost findByPostId(String postId) {
		return msgPostRepository.findByPostId(postId);
	}

	public MsgPost save(MsgPost msgPost) {
		return msgPostRepository.save(msgPost);
	}

	/*
	 * public void deleteMsgPost() { msgPostRepository.deleteMsgPost();
	 * System.out.println("删除成功！"); }
	 */

	public void delete(MsgPost msgPost) {
		msgPostRepository.delete(msgPost);
		System.out.println("删除成功！");
	}

	public List<MsgReplies> findRepliesByPostId(String postId) {
		List<MsgReplies> list = msgPostRepository.findRepliesByPostId(postId);
		System.out.println("查询成功！");
		return list;
	}

	public int updatePost(String postTitle, String postContent, String postId) {
		int isUpdated = -1;
		return isUpdated;
	}
}
