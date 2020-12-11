package com.tensquare.usercrawler.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//ID



	private String mobile;
	private String password;
	private String nickname;
	private String sex;
	private java.util.Date birthday;
	private String avatar;
	private String email;
	private java.util.Date regdate;
	private java.util.Date updatedate;
	private java.util.Date lastdate;
	private Long online;
	private String interest;
	private String personality;
	private Integer fanscount;
	private Integer followcount;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getRegdate() {
		return regdate;
	}
	public void setRegdate(java.util.Date regdate) {
		this.regdate = regdate;
	}

	public java.util.Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	public java.util.Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(java.util.Date lastdate) {
		this.lastdate = lastdate;
	}

	public Long getOnline() {
		return online;
	}
	public void setOnline(Long online) {
		this.online = online;
	}

	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public Integer getFanscount() {
		return fanscount;
	}
	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getFollowcount() {
		return followcount;
	}
	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}



}