package com.jaeseong.kakao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeseong.kakao.dao.MemberMapper;
import com.jaeseong.kakao.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	public int member_check(MemberDTO mdto){
		
		if(mapper.getLoginMember(mdto.getUserid())==null){
			//id not exist
			return -1;
		}else {
			//id exist
			MemberDTO mTest = mapper.getLoginMember(mdto.getUserid());
			//password
			if(!mTest.getPassword().equals(mdto.getPassword())){
				//not login -password not equal
				return 0;
			}else 
				return 1;
		}
	}
	
	public MemberDTO getLoginMember(String userid) {
		return mapper.getLoginMember(userid);
	}
	
	public MemberDTO getMemberbyId(int id) {
		return mapper.getMemberbyId(id);
	}
	
	public List<MemberDTO> getFriends(MemberDTO mdto){
		return mapper.getFriends(mdto);
	}
}
