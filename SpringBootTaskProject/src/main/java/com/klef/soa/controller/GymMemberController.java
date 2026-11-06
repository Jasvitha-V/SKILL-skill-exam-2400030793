	package com.klef.soa.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	
	import com.klef.soa.entity.GymMember;
	import com.klef.soa.service.GymMemberService;
	
	@RestController
	@RequestMapping("/gymmember")
	public class GymMemberController
	{
		@Autowired
		private GymMemberService service;
	
		@GetMapping("/")
		public String demo()
		{
			return "Spring Boot Task Project";
		}
	
		// Add Gym Member
		@PostMapping("/add")
		public ResponseEntity<GymMember> addGymMember(@RequestBody GymMember g)
		{
			GymMember gymMember = service.addGymMember(g);
			return ResponseEntity.status(201).body(gymMember);
		}
	
		// Display All Gym Members
		@GetMapping("/displayall")
		public ResponseEntity<List<GymMember>> displayAllGymMembers()
		{
			List<GymMember> gymMembers = service.displayAllGymMembers();
			return ResponseEntity.status(200).body(gymMembers);
		}
	
		// Display Gym Member By ID
		@GetMapping("/display")
		public ResponseEntity<?> displayGymMemberById(@RequestParam Long gymMemberId)
		{
			GymMember gymMember = service.displayGymMemberById(gymMemberId);
	
			if(gymMember != null)
			{
				return ResponseEntity.status(200).body(gymMember);
			}
			else
			{
				return ResponseEntity.status(404).body("Gym Member ID Not Found");
			}
		}
	
		// Update Gym Member
		@PutMapping("/update")
		public ResponseEntity<?> updateGymMember(@RequestBody GymMember gymMember)
		{
			GymMember g = service.updateGymMember(gymMember);
	
			if(g != null)
			{
				return ResponseEntity.ok(g);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gym Member ID Not Found");
			}
		}
	
		// Delete Gym Member By ID
		@DeleteMapping("/delete/{gymMemberId}")
		public ResponseEntity<String> deleteGymMemberById(@PathVariable Long gymMemberId)
		{
			String message = service.deleteGymMemberById(gymMemberId);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	
		// Display Gym Members By Name
		@GetMapping("/displaybyname/{name}")
		public ResponseEntity<List<GymMember>> displayGymMembersByName(@PathVariable String name)
		{
			List<GymMember> gymMembers = service.displayGymMembersByName(name);
			return ResponseEntity.status(200).body(gymMembers);
		}
	
		// Display Gym Members By Type
		@GetMapping("/displaybytype/{type}")
		public ResponseEntity<List<GymMember>> displayGymMembersByType(@PathVariable String type)
		{
			List<GymMember> gymMembers = service.displayGymMembersByType(type);
			return ResponseEntity.status(200).body(gymMembers);
		}
	
	}