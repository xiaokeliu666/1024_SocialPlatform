package com.tensquare.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * Column Entity
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_column")
public class Column implements Serializable{

	@Id
	private String id;



	private String name;
	private String summary;
	private String userid;
	private java.util.Date createtime;
	private java.util.Date checktime;
	private String state;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getChecktime() {
		return checktime;
	}
	public void setChecktime(java.util.Date checktime) {
		this.checktime = checktime;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}



}
