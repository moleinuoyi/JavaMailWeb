package com.zwt.modle;

import java.util.Date;

public class User {
	private Integer id;
	private String mailName;
	private String userName;
	private String userImage;
	private String password;
	private Integer sex;
	private int age;
	private Date brithdy;
	private String phone;
	private Date registerTime;
	private Date lastLoadTime;
	private String discription;
	private String quession;
	private String answer;
	private Integer roleId;
	private Integer registeStatu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBrithdy() {
		return brithdy;
	}
	public void setBrithdy(Date brithdy) {
		this.brithdy = brithdy;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getLastLoadTime() {
		return lastLoadTime;
	}
	public void setLastLoadTime(Date lastLoadTime) {
		this.lastLoadTime = lastLoadTime;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getQuession() {
		return quession;
	}
	public void setQuession(String quession) {
		this.quession = quession;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRegisteStatu() {
		return registeStatu;
	}
	public void setRegisteStatu(Integer registeStatu) {
		this.registeStatu = registeStatu;
	}
	
}
