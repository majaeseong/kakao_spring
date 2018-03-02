package com.jaeseong.kakao.dto;

import java.sql.Timestamp;

public class ChattingDTO {
	private int id, send_id, res_id;
	private String content;
	private Timestamp r_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSend_id() {
		return send_id;
	}
	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
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
