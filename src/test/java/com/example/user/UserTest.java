package com.example.user;


	

	import static org.junit.jupiter.api.Assertions.*;

	import java.util.List;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.dao.UserService;
	import com.model.Seat;


	import junit.framework.Assert;

	@SpringBootTest
	class UserTest {
		@Autowired
		UserService service;

		@Test
		void testAdd() {
			Seat s=new Seat();
			s.setSeatNo(100);
			s.setSeatType("AC");
			s.setOffice("third");
			s.setFloor(12);
			s.setLocation("Mumbai");
			service.add(s);
			
			Seat s1=service.find(s.getSeatId());
			Assert.assertEquals("AC",s.getSeatType());
			Assert.assertEquals(100, s.getSeatNo());
			Assert.assertEquals("third", s.getOffice());
			Assert.assertEquals(12,s.getFloor());
			
		}

		@Test
		void validateSeat() {
			Seat s=new Seat();
			s.setSeatNo(200);
			try {
			service.add(s);
			}
			catch(Exception e) {
				System.out.println(e);
			}	
			s.setOffice("Normal");
			try {
			service.add(s);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			Seat s3=service.find(s.getSeatId());
			Assert.assertNotNull(s3);
			Assert.assertNotNull(s3);
		}
		
		@Test
		void testFind() {
			Seat s4=new Seat();
			s4.setFloor(25);
			Seat s5=service.find(s4.getSeatId());
			Assert.assertNull(s5);
			
		}
		

		@Test
		void testFindAll() {
			Seat s=new Seat();
			s.setSeatNo(10);
			s.setFloor(10);
			s.setSeatType("AC");
			s.setOffice("Second");
			s.setFloor(3);
			s.setLocation("Mumbai");
			s.getSeatId();
			service.add(s);
			Seat s1=new Seat();
			s1.setSeatNo(11);
			s1.setSeatType("Normal");
			s1.setOffice("Third");
			s1.setFloor(11);
			s.setLocation("ballarpur");
			s1.getSeatId();
			service.add(s1);
			List<Seat> seatlist=service.findAll();
			
			Assert.assertEquals(seatlist.get(2).getLocation(),"mumbai");
			Assert.assertEquals(seatlist.get(3).getLocation(), "ballarpur");
			
			
		}

		@Test
		void testUpdate() {
			
			Seat sc=new Seat();
			sc.setSeatNo(19);
			sc.setSeatType("Normal");
			sc.setOffice("fifth");
			sc.setFloor(7);
			sc.setLocation("kerala");
			service.add(sc);
			sc.setSeatType("AC");
			service.update(sc);
			Assert.assertEquals(true, service.update(sc));
		}

		@Test
		void testDelete() {
			Seat s1=service.find(6);
			service.delete(s1.getSeatId());
			if(s1!=null) {
				System.out.println("not deleted*********");
				
			}
			Seat s2=service.find(6);
			
			Assert.assertNull(s2);
		}

	}


