package com.jaeseong.kakao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jaeseong.kakao.dto.ChattingDTO;

public interface ChattingMapper {
	public ChattingDTO getAllChats(@Param("id_1") int id_1, @Param("id_2") int id_2);
	public int getMaxId();
	public List<ChattingDTO> getAllchatting(@Param("id_1") int id_1, @Param("id_2") int id_2);
	public void addChatText(ChattingDTO cdto);
	public int getLastChat(@Param("id_1") int id_1, @Param("id_2") int id_2);

}
