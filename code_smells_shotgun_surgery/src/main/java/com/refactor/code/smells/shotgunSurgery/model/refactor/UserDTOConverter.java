package com.refactor.code.smells.shotgunSurgery.model.refactor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.refactor.code.smells.shotgunSurgery.model.User;
import com.refactor.code.smells.shotgunSurgery.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "true")
@Component
public class UserDTOConverter {

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public List<UserDTO> convertToDTO(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }


}

