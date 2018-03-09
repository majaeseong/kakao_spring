package com.jaeseong.kakao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeseong.kakao.dao.ChattingMapper;
import com.jaeseong.kakao.dao.MemberMapper;
import com.jaeseong.kakao.dto.ChatListDTO;
import com.jaeseong.kakao.dto.ChattingDTO;
import com.jaeseong.kakao.dto.MemberDTO;

@Service
public class ChattingSerivce {
	
	@Autowired
	ChattingMapper mapper;
	
	@Autowired
	MemberMapper mm;
	
	public List<ChatListDTO> getAllChatList(int id){
		
		List<ChatListDTO> chats_list = new ArrayList<ChatListDTO>();
		int max_id = mapper.getMaxId();
		
		for (int i=1;i<=max_id;i++) {
			if(i==id) continue;
			
			ChattingDTO cdto = mapper.getAllChats(id, i);
			ChatListDTO cldto = new ChatListDTO();
			MemberDTO mdto = mm.getMemberbyId(i);
			
			cldto.setId(i);	cldto.setName(mdto.getName()); cldto.setContent(cdto.getContent());
			cldto.setImages(mdto.getImages()); cldto.setR_time(cdto.getR_time());
			
			chats_list.add(cldto);
		}
		
		return chats_list;
		
	}
	
	public List<ChattingDTO> getAllchatting(int id_1, int id_2){
		return mapper.getAllchatting(id_1, id_2);
	}
	
	public void addChatText(ChattingDTO cdto) {
		mapper.addChatText(cdto);
	}

	public int getLastChat(int id_1, int id_2) {
		
		return mapper.getLastChat(id_1,id_2);
	}

}
