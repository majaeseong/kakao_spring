package com.jaeseong.kakao.dao;

import java.util.List;

import com.jaeseong.kakao.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO getLoginMember(String userid);
	public MemberDTO getMemberbyId(int id);
	public List<MemberDTO> getFriends(MemberDTO mdto);
	public void edit_profile(MemberDTO mdto);
}
