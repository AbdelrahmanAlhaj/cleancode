package com.refactor.code.smells.shotgunSurgery.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "false")
public class UserDTOConverter {

	public static UserDTO convertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

}

