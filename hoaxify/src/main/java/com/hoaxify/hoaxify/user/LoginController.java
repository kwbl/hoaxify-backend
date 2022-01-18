package com.hoaxify.hoaxify.user;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.hoaxify.shared.CurrentUser;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	@JsonView(Views.Base.class)
	User handleLogin(@CurrentUser User loggedInUser) {
		/*
		 * Map<String, Object> userMap = new HashMap<>(); userMap.put("id",
		 * loggedInUser.getId()); userMap.put("image", loggedInUser.getImage()); return
		 * userMap;
		 */
		return loggedInUser;
		
	}
}
