package com.jaeseong.kakao.dao;

import org.apache.ibatis.annotations.Param;

import com.jaeseong.kakao.dto.ChattingDTO;

public interface ChattingMapper {
	public ChattingDTO getAllChats(@Param("id_1") int id_1, @Param("id_2") int id_2);
	public int getMaxId();
	

}
