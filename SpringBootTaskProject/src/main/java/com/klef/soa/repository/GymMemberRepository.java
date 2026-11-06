package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.GymMember;

@Repository
public interface GymMemberRepository extends JpaRepository<GymMember, Long>
{
	
	List<GymMember> findByName(String name);

	List<GymMember> findByType(String type);
}