package com.post.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "INFO_T_MSGREPLIES")
public class MsgReplies {
	private String repliesId;
	private MsgPost msgPost;
	private String repliesContent;
	private String repliesUserId;
	private String repliesName;
	private String repliesTime;
	private Integer repliesStatus;
	private String appTime;
	private String appUserId;
	private String appUserName;
	private String appContent;
	private String remark;

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "REPLIESID", nullable = false, length = 32)
	public String getRepliesId() {
		return repliesId;
	}

	public void setRepliesId(String repliesId) {
		this.repliesId = repliesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTID", nullable = false)
	public MsgPost getMsgPost() {
		return msgPost;
	}

	public void setMsgPost(MsgPost msgPost) {
		this.msgPost = msgPost;
	}

	@Column(name = "REPLIESCONTENT", length = 4000)
	public String getRepliesContent() {
		return repliesContent;
	}

	public void setRepliesContent(String repliesContent) {
		this.repliesContent = repliesContent;
	}

	@Column(name = "REPLIESUSERID", length = 50)
	public String getRepliesUserId() {
		return repliesUserId;
	}

	public void setRepliesUserId(String repliesUserId) {
		this.repliesUserId = repliesUserId;
	}

	@Column(name = "REPLIESNAME", length = 100)
	public String getRepliesName() {
		return repliesName;
	}

	public void setRepliesName(String repliesName) {
		this.repliesName = repliesName;
	}

	@Column(name = "REPLIESTIME", length = 14)
	public String getRepliesTime() {
		return repliesTime;
	}

	public void setRepliesTime(String repliesTime) {
		this.repliesTime = repliesTime;
	}

	@Column(name = "REPLIESSTATUS")
	public Integer getRepliesStatus() {
		return repliesStatus;
	}

	public void setRepliesStatus(Integer repliesStatus) {
		this.repliesStatus = repliesStatus;
	}

	@Column(name = "APPTIME", length = 14)
	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	@Column(name = "APPUSERID", length = 50)
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

	@Column(name = "REMARK", length = 4000)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
