package com.song.hospital.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class UserVO implements Serializable {

	private static final long serialVersionUID = -3293569812582770353L;

	private Integer id;// 主键ID

	private String userid;// 用户ID

	private String username;// 用户名

	private String realname;// 真实姓名

	private String email;// Email

	private Date birthday;// 出生日期

	private Timestamp createtime;// 注册时间

	private String token;// token

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
