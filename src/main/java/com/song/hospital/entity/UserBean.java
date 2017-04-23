package com.song.hospital.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * <p>
 * Title: hospital_[子系统名称]_[用户模块]
 * </p>
 * <p>
 * Description: [User Bean]
 * </p>
 * 
 * @author SOYU
 * @version $Revision$ 2017年4月23日
 * @author (lastest modification by $Author$)
 * @since 20100901
 */
public class UserBean implements Serializable {

	/**
	 * 序列化，http://blog.csdn.net/jediael_lu/article/details/26813153
	 */
	private static final long serialVersionUID = 8436064265279211011L;

	private Integer id;// 主键ID

	private String userid;// 用户ID

	private String username;// 用户名

	private String realname;// 真实姓名

	private String email;// Email

	private Date birthday;// 出生日期

	private Timestamp createtime;// 注册时间

	private String password;// 登录密码

	private String passwordsalt;// 密码盐

	private String sex;// 性别

	private Integer version;// 乐观锁版本号

	public UserBean() {
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordsalt() {
		return passwordsalt;
	}

	public void setPasswordsalt(String passwordsalt) {
		this.passwordsalt = passwordsalt;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
