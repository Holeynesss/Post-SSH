package com.post.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.post.entity.MsgPost;
import com.post.entity.MsgReplies;
import com.post.service.MsgPostService;
import com.post.service.MsgRepliesService;

@Controller
@RequestMapping("/replies/")
public class MsgRepliesController {
	@Autowired
	private MsgRepliesService msgRepliesService;
	@Autowired
	private MsgPostService msgPostService;

	@RequestMapping(value = "insertPost", method = RequestMethod.POST)
	public ModelAndView saveReplies(HttpServletRequest request,
			MsgReplies msgReplies) {
		ModelAndView mv = new ModelAndView();
		String postId = request.getParameter("postId");
		fillMsgReplies(postId, msgReplies);
		msgRepliesService.save(msgReplies);
		mv.setViewName("succeed");
		mv.addObject("postId", postId);
		mv.addObject("succeedAction", "msgPost/showPost?postId=" + postId);
		return mv;

	}

	/* 屏蔽回复 即修改RepliesStatus的值 */
	@RequestMapping(value = "admin/blockReply", method = RequestMethod.GET)
	public ModelAndView blockReply(MsgReplies reply) {
		ModelAndView mv = new ModelAndView();
		reply = msgRepliesService.findReplyByRepliesId(reply.getRepliesId());
		reply.setRepliesStatus(-1);
		msgRepliesService.save(reply);
		mv.addObject("succeedAction", "msgPost/showPost?postId="
				+ reply.getMsgPost().getPostId());
		mv.setViewName("succeed");
		return mv;
	}

	/*
	 * @RequestMapping(value = "transfer") public ModelAndView
	 * pageTransfer(HttpServletRequest request) { ModelAndView mv = new
	 * ModelAndView(); String postId = request.getParameter("postId"); MsgPost
	 * currentPost = msgPostService.findByPostId(postId); List<MsgReplies> list
	 * = msgPostService.findRepliesByPostId(postId); mv.addObject("currentPost",
	 * currentPost); mv.addObject("replies", attributeValue)
	 * mv.setViewName("postDetail"); return mv; }
	 */

	private MsgReplies fillMsgReplies(String postId, MsgReplies msgReplies) {
		/* 设置时间 */
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		msgReplies.setRepliesTime(dateString);
		msgReplies.setRepliesStatus(1);
		/* 设置Post */
		MsgPost msgPost = msgPostService.findByPostId(postId);
		System.out.println("POST的值为：>>>>" + msgPost);
		msgReplies.setMsgPost(msgPost);
		return msgReplies;
	}
}
