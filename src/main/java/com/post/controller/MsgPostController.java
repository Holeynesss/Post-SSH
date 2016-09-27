package com.post.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.post.entity.MsgPost;
import com.post.entity.MsgReplies;
import com.post.service.MsgPostService;

@Controller
@RequestMapping("/msgPost/")
public class MsgPostController {
	@Autowired
	private MsgPostService msgPostService;
	private int searchWay;

	/* 查询功能，无权限 */
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll(HttpServletRequest request) {
		int pn = Integer.parseInt(request.getParameter("pn"));
		int ps = Integer.parseInt(request.getParameter("ps"));
		int hasNext = 1;
		ModelAndView mv = new ModelAndView();
		Page<MsgPost> page = msgPostService.page(pn, ps);
		Iterator<MsgPost> it= page.iterator();
		if(page.hasNextPage()!=true)
			hasNext = -1;
		mv.addObject("postList", it);
		mv.setViewName("home");
		mv.addObject("currentPage", pn);
		mv.addObject("ps", ps);
		mv.addObject("hasNext", hasNext);
		return mv;
	}

	/* 帖子详细显示 */
	@RequestMapping(value = "showPost", method = RequestMethod.GET)
	public ModelAndView editPost(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String postId = request.getParameter("postId");
		MsgPost currentPost = msgPostService.findByPostId(postId);
		List<MsgReplies> replies = msgPostService.findRepliesByPostId(postId);
		System.out.println("Replies的长度为：" + replies.size());
		mv.addObject("currentPost", currentPost);
		mv.addObject("replies", replies);
		mv.setViewName("postDetail");
		return mv;
	}

	@RequestMapping(value = "findByKeyWord", method = RequestMethod.POST)
	public ModelAndView findByKeyWord(HttpServletRequest request) {
		String keyWord = "%" + request.getParameter("keyWord") + "%";
		searchWay = Integer.parseInt(request.getParameter("searchWay"));
		ModelAndView mv = new ModelAndView("home");
		/* postWithKeyList */
		mv.addObject("postList", findByMultiWay(searchWay, keyWord));
		return mv;
	}

	/* 写帖子功能 权限为ROLE_USER */
	@RequestMapping(value = "user/insertPost", method = RequestMethod.POST)
	public ModelAndView insertPost(MsgPost msgPost) {
		ModelAndView mv = new ModelAndView();
		fillMsgPost(msgPost);
		System.out.println("标题:" + msgPost.getPostTitle());
		mv.addObject("current", msgPostService.save(msgPost));
		mv.addObject("succeedAction", "msgPost/findAll?pn=0&ps=5");
		mv.setViewName("succeed");
		return mv;
	}

	/* 跳转至修改页面 权限ROLE_USER */
	@RequestMapping(value = "user/transferUpdatePage", method = RequestMethod.GET)
	public ModelAndView transferUpdatePage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String postId = request.getParameter("postId");
		mv.setViewName("updatePage");
		mv.addObject("currentPost", msgPostService.findByPostId(postId));
		return mv;
	}

	/* 修改帖子内容 */
	@RequestMapping(value = "user/updatePost", method = RequestMethod.POST)
	public ModelAndView updatePost(MsgPost msgPost) {
		ModelAndView mv = new ModelAndView();
		/*
		 * String postTitle = request.getParameter("postTitle"); String
		 * postContent = request.getParameter("postContent"); String postId =
		 * request.getParameter("postId"); int isUpdated =
		 * msgPostService.updatePost(postTitle, postContent, postId);
		 * mv.addObject("isUpdated", isUpdated);
		 */
		msgPostService.save(msgPost);
		mv.addObject("succeedAction",
				"msgPost/showPost?postId=" + msgPost.getPostId());// 中间跳转>>
		mv.setViewName("succeed");
		return mv;
	}

	/* 删除帖子功能 权限为ROLE_ADMIN */
	@RequestMapping(value = "admin/deletePost", method = RequestMethod.GET)
	public ModelAndView deleteByPostId(HttpServletRequest request, String postId) {
		ModelAndView mv = new ModelAndView();
		System.out.println("postId的值为：" + request.getParameter("postId"));
		MsgPost currentPost = msgPostService.findByPostId(request
				.getParameter("postId"));
		msgPostService.delete(currentPost);
		mv.setViewName("succeed");
		mv.addObject("succeedAction", "msgPost/findAll");
		return mv;
	}

	private List<MsgPost> findByMultiWay(int searchWay, String keyWord) {
		List<MsgPost> list = null;
		switch (searchWay) {
		case 1: {
			list = msgPostService.findByKeyWord(keyWord);
			System.out.println("查询到的list长度为：" + list.size());
			break;
		}

		case 2: {
			list = msgPostService.findByPostTitle(keyWord);
			break;
		}
		default:
			break;
		}
		return list;
	}

	private MsgPost fillMsgPost(MsgPost msgPost) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		msgPost.setPostTime(dateString);
		return msgPost;
	}
}
