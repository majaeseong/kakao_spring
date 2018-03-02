package com.jaeseong.kakao.dto;

public class MemberDTO {
	private int id;
	private String userid, password, name, statusmsg, images;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatusmsg() {
		return statusmsg;
	}
	public void setStatusmsg(String statusmsg) {
		this.statusmsg = statusmsg;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	
}
