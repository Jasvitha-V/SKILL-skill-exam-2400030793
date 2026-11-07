package com.klef.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.GymMember;
import com.klef.soa.repository.GymMemberRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GymMemberRepositoryTest
{
    @Autowired
    private GymMemberRepository repository;
    
    @Test
    void testFindAllGymMembers()
    {
        GymMember g = new GymMember();
        g.setName("Anjali");
        g.setType("Premium");
        g.setStatus(false);
        g.setLocation("Chennai");

        repository.save(g);

        List<GymMember> members = repository.findAll();

        assertNotNull(members);
        assertFalse(members.isEmpty());

        System.out.println("Total Gym Members: " + members.size());
    }

    @Test
    void testFindGymMemberById()
    {
        GymMember g = new GymMember();
        g.setName("Anjali");
        g.setType("Premium");
        g.setStatus(false);
        g.setLocation("Chennai");

        GymMember saved = repository.save(g);

        Optional<GymMember> member =
                repository.findById(saved.getGymMemberId());

        assertTrue(member.isPresent());
        assertEquals(saved.getGymMemberId(),
                     member.get().getGymMemberId());

        System.out.println("Gym Member ID: " +
                member.get().getGymMemberId());
        System.out.println("Name: " + member.get().getName());

        Optional<GymMember> invalidMember =
                repository.findById(1L);

        assertFalse(invalidMember.isPresent());
    }

    @Test
    void testFindGymMemberByName()
    {
        GymMember g = new GymMember();
        g.setName("RahulTest");
        g.setType("Premium");
        g.setStatus(true);
        g.setLocation("Hyderabad");

        repository.save(g);

        List<GymMember> members =
                repository.findByName("RahulTest");

        assertNotNull(members);
        assertFalse(members.isEmpty());
        assertEquals("RahulTest", members.get(0).getName());

        System.out.println("Member Name: " +
                members.get(0).getName());
    }

    @Test
    void testTotalGymMemberCount()
    {
        long initialCount = repository.count();

        GymMember g = new GymMember();
        g.setName("Rahul");
        g.setType("Premium");
        g.setStatus(true);
        g.setLocation("Hyderabad");

        repository.save(g);

        long finalCount = repository.count();

        assertEquals(initialCount + 1, finalCount);

        System.out.println("Total Gym Members: " + finalCount);
    }

    @Test
    void testGymMemberDetailsAndType()
    {
        GymMember g = new GymMember();
        g.setName("Suresh");
        g.setType("Gold");
        g.setStatus(true);
        g.setLocation("Vijayawada");

        GymMember saved = repository.save(g);

        Optional<GymMember> member =
                repository.findById(saved.getGymMemberId());

        assertTrue(member.isPresent());

        GymMember foundMember = member.get();

        assertNotNull(foundMember.getName());
        assertNotNull(foundMember.getType());
        assertNotNull(foundMember.getLocation());

        System.out.println("Name: " + foundMember.getName());
        System.out.println("Type: " + foundMember.getType());
        System.out.println("Status: " + foundMember.isStatus());
        System.out.println("Location: " + foundMember.getLocation());

        List<GymMember> members =
                repository.findByType("Gold");

        assertNotNull(members);
        assertFalse(members.isEmpty());
        assertEquals("Gold", members.get(0).getType());

        System.out.println("Members with Gold Type: " +
                members.size());
    }
}
