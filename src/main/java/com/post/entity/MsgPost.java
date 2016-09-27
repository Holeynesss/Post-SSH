package com.post.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "INFO_T_MSGPOST")
public class MsgPost {
	private String postId;
	private String postTitle;
	private String postContent;
	private String postTime;
	private String postIndex;
	private String keyWords;
	private String postUserId;
	private String postUserName;
	private int browerCount;
	private String remark;
	private String appTime;
	private String appUserId;
	private String appUserName;
	private String appContent;
	private Set<MsgReplies> replies = new HashSet<MsgReplies>();
	
	
	public MsgPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgPost(String postId, String postTitle, String postContent,
			String postTime, String postIndex, String keyWords,
			String postUserId, String postUserName, int browerCount,
			String remark, String appTime, String appUserId,
			String appUserName, String appContent) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postTime = postTime;
		this.postIndex = postIndex;
		this.keyWords = keyWords;
		this.postUserId = postUserId;
		this.postUserName = postUserName;
		this.browerCount = browerCount;
		this.remark = remark;
		this.appTime = appTime;
		this.appUserId = appUserId;
		this.appUserName = appUserName;
		this.appContent = appContent;
	}
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "POSTID", unique = true, nullable = false, length = 32)
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	@Column(name = "POSTTITLE", length = 200)
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	@Column(name="POSTCONTENT", length = 4000)
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	@Column(name="POSTTIME", length = 14)
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	@Column(name="POSTINDEX", length = 100)
	public String getPostIndex() {
		return postIndex;
	}
	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}
	
	@Column(name = "KEYWORDS", nullable = false, length = 500)
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	@Column(name = "POSTUSERID", length = 50)
	public String getPostUserId() {
		return postUserId;
	}
	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}
	
	@Column(name = "POSTUSERNAME", length = 100)
	public String getPostUserName() {
		return postUserName;
	}
	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}
	
	@Column(name = "BROWERCOUNT")
	public int getBrowerCount() {
		return browerCount;
	}
	public void setBrowerCount(int browerCount) {
		this.browerCount = browerCount;
	}
	
	@Column(name = "REMARK", length = 4000)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "APPTIME", length = 14)
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	
	@Column(name="APPUSERID", length = 50)
	public String getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
	
	@Column(name = "APPUSERNAME", length = 100)
	public String getAppUserName() {
		return appUserName;
	}
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	
	@Column(name = "APPCONTENT", length = 4000)
	public String getAppContent() {
		return appContent;
	}
	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msgPost")
	public Set<MsgReplies> getReplies() {
		return replies;
	}
	public void setReplies(Set<MsgReplies> replies) {
		this.replies = replies;
	}
}
