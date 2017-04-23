package com.song.hospital.entity;

import java.io.Serializable;

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
	 * generated
	 */
	private static final long serialVersionUID = 3355971530456471082L;

	private Integer id;

	private String username;

	private String password;

	private Double account;

	public UserBean() {
	}

	public UserBean(String username, String password, Double account) {
		this.username = username;
		this.password = password;
		this.account = account;
	}

	public UserBean(Integer id, String username, String password, Double account) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getAccount() {
		return account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ "]";
	}

}
