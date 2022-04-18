package seatprojectApplication;

public class SeatProjectTest {
	package seatprojectmanagement;

	public class SeatProjectTest {
		

	import static org.junit.jupiter.api.Assertions.*;

	import java.util.List;
	import javax.validation.ConstraintViolationException;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.context.annotation.Profile;

	import com.dao.SeatProjectService;
	import com.model.SeatProjectDetails;

	import junit.framework.Assert;
	@SpringBootTest
	class SeatProjectTest {
	  @Autowired
	  SeatProjectService service;
		@Test
		void testAdd() {
			UserProfileDetails profile=new UserProfileDetails();
			profile.setUserName("Nitin");
			profile.setUseremailId("nitinmohurle184@gmail.com");
			profile.setAddress("ballarpur");
			profile.setAge(25);
			profile.setDob("29/03/1996");
			profile.setMobile("9699275159");	
			service.add(profile);
			
			UserProfileDetails profile1=service.find(profile.getUserId());
				Assert.assertEquals("Nitin", profile1.getUserName());
			Assert.assertEquals("nitinmohurle184@gmail.com", profile1.getUseremailId());
			Assert.assertEquals("ballarpur", profile1.getAddress());
			Assert.assertEquals(25, profile1.getAge());
			Assert.assertEquals("29/03/1996", profile1.getDob());
			Assert.assertEquals("9699275159", profile1.getMobile());
			
			
		}
		
		@Test
		void validateTestForProfile() {
			UserProfileDetails profile2=new UserProfileDetails();
			profile2.setAge(25);
			try {
			service.add(profile2);
			}
			catch(Exception e) {
				System.out.println(e);
			}	
			profile2.setUserName("krish");
			try {
			service.add(profile2);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			UserProfileDetails profile3=service.find(profile2.getUserId());
			Assert.assertNull(profile3);
			Assert.assertNull(profile3);
			
		}
		@Test
		void testFind() {
			UserProfileDetails profile4=new UserProfileDetails();
			profile4.setAge(25);
			UserProfileDetails profile8=service.find(profile4.getUserId());
			Assert.assertNull(profile8);
		}

		@Test
		void testFindAll() {
			UserProfileDetails profile5=new UserProfileDetails();
			profile5.setUserName("Nitin");
			profile5.setAddress("ballarpur");
			profile5.setAge(24);
			profile5.setDob("29/03/1996");
			profile5.setMobile("9699275159")	;
			profile5.setUseremailId("nitin@gmail.com");
			profile5.getUserId();
			service.add(profile5);
			UserProfileDetails profile6=new UserProfileDetails();
			profile6.setUserName("Ranjitha");
			profile6.setAddress("shubham");
			profile6.setAge(25);
			profile6.setDob("21/09/1996");
			profile6.setMobile("9983547899")	;
			profile6.setUseremailId("Ranjitha@gmail.com");
			profile6.getUserId();
			service.add(profile6);
			UserProfileDetails profile7=new UserProfileDetails();
			profile7.setUserName("vaish");
			profile7.setAddress("Mumbai");
			profile7.setAge(26);
			profile7.setDob("21/12/1995");
			profile7.setMobile("9987097628")	;
			profile7.setUseremailId("vaish@gmail.com");
			profile7.getUserId();
			service.add(profile7);
			UserProfileDetails profile8=new UserProfileDetails();
			profile8.setUserName("Rekha");
			profile8.setAddress("Goa");
			profile8.setAge(28);
			profile8.setDob("10/09/1993");
			profile8.setMobile("9987090928")	;
			profile8.setUseremailId("Rekha@gmail.com");
			profile8.getUserId();
			service.add(profile8);
			List<UserProfileDetails> profilelist=service.findAll();
			Assert.assertEquals(profilelist.get(3).getAge(), 26);
			Assert.assertEquals(profilelist.get(2).getUserName(),"Nitin");
			Assert.assertEquals(profilelist.get(1).getUserName(), "Ranjitha");
			Assert.assertEquals(profilelist.get(2).getAge(), 25);
			Assert.assertEquals(profilelist.get(3).getUserName(), "vaish");
			
		}

	  @Test
		void testUpdate() {
		UserProfileDetails uc=new UserProfileDetails();
		uc.setUserName("sukanya");
		uc.setUseremailId("sukanya@gmail.com");
		uc.setAddress("chennai");
		uc.setAge(30);
		uc.setDob("07/08/2000");
		uc.setMobile("9087543790");
		service.add(uc);
		uc.setAge(32);
		service.update(uc);
		Assert.assertEquals(true, service.update(uc));
				
		}

		@Test
		void testDelete() {
			UserProfileDetails u1=service.find(6);
			service.delete(u1.getUserId());
			if(u1!=null) {
				System.out.println("not deleted*********");
				
			}
			UserProfileDetails u2=service.find(6);
			
			Assert.assertNull(u2);
			
			
			
			
		}

	}

	}

}
