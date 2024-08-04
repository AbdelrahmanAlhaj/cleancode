package com.refactor.code.smells.shotgunSurgery.controller.refactor;

import com.refactor.code.smells.shotgunSurgery.model.User;
import com.refactor.code.smells.shotgunSurgery.model.UserDTO;
import com.refactor.code.smells.shotgunSurgery.model.refactor.UserDTOConverter;
import com.refactor.code.smells.shotgunSurgery.service.UserCRUDService;
import com.refactor.code.smells.shotgunSurgery.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "true")
@RestController
@RequestMapping("/users")
public class UserController implements UserCRUDService {

    private final UserService userService;
    private final UserDTOConverter userDTOConverter;

    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    @PostMapping
    @Override
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        User createdUser = userService.createUser(user);
        return userDTOConverter.convertToDTO(createdUser);
    }

    @PutMapping("/{id}")
    @Override
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        User updatedUser = userService.updateUser(id, user);
        return userDTOConverter.convertToDTO(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    @Override
    public UserDTO getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userDTOConverter.convertToDTO(user);
    }

    @GetMapping
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userDTOConverter.convertToDTO(users);
    }
}
