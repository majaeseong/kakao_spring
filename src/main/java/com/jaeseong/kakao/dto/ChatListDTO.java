package com.jaeseong.kakao.dto;

import java.sql.Timestamp;

public class ChatListDTO {
	private int id;
	private String name,images,content;
	private Timestamp r_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getR_time() {
		return r_time;
	}
	public void setR_time(Timestamp r_time) {
		this.r_time = r_time;
	}
	
	
}
