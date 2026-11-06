package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.GymMember;
import com.klef.soa.repository.GymMemberRepository;

@Service
public class GymMemberServiceImpl implements GymMemberService
{
	@Autowired
	private GymMemberRepository repo;

	@Override
	public GymMember addGymMember(GymMember g)
	{
		return repo.save(g);
	}

	@Override
	public GymMember updateGymMember(GymMember g)
	{
		Optional<GymMember> optional = repo.findById(g.getGymMemberId());

		if(optional.isPresent())
		{
			GymMember gymMember = optional.get();

			gymMember.setName(g.getName());
			gymMember.setType(g.getType());
			gymMember.setStatus(g.isStatus());
			gymMember.setLocation(g.getLocation());

			return repo.save(gymMember);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<GymMember> displayAllGymMembers()
	{
		return repo.findAll();
	}

	@Override
	public GymMember displayGymMemberById(Long gymMemberId)
	{
		return repo.findById(gymMemberId).orElse(null);
	}

	@Override
	public String deleteGymMemberById(Long gymMemberId)
	{
		boolean flag = repo.existsById(gymMemberId);

		if(flag)
		{
			repo.deleteById(gymMemberId);
			return "Gym Member Deleted Successfully";
		}
		else
		{
			return "Gym Member ID Not Found";
		}
	}

	@Override
	public List<GymMember> displayGymMembersByName(String name)
	{
		return repo.findByName(name);
	}

	@Override
	public List<GymMember> displayGymMembersByType(String type)
	{
		return repo.findByType(type);
	}
}