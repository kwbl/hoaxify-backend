package com.hoaxify.hoaxify;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoaxify.hoaxify.user.User;
import com.hoaxify.hoaxify.user.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void findByUsername_whenUserExists_returnUser() {
		
		  
		  testEntityManager.persist(TestUtil.createValidUser());
		  
		  User dbUser = userRepository.findByUsername("test-user");
		  assertThat(dbUser).isNotNull();
	}
	
	@Test
	public void findByUsername_whenUserDoesNotExist_returnsNull() {
		
		User dbUser = userRepository.findByUsername("test-user");
		assertThat(dbUser).isNull();
		
	}

}
