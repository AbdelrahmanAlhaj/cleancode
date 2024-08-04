package com.refactor.code.smells.shotgunSurgery.service;

import java.util.List;

import com.refactor.code.smells.shotgunSurgery.model.UserDTO;

public interface UserCRUDService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    UserDTO getUser(Long id);

    List<UserDTO> getAllUsers();

}
