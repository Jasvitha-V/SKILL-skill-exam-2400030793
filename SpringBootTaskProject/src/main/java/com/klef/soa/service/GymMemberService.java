package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.GymMember;

public interface GymMemberService
{
	GymMember addGymMember(GymMember g);
	GymMember updateGymMember(GymMember g);
	List<GymMember> displayAllGymMembers();
	GymMember displayGymMemberById(Long gymMemberId);
	String deleteGymMemberById(Long gymMemberId);
	List<GymMember> displayGymMembersByName(String name);
	List<GymMember> displayGymMembersByType(String type);
}