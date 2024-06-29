package com.refactor.code.kiss.principle.controller.refactor;

import com.refactor.code.kiss.principle.dto.UserDTO;
import com.refactor.code.kiss.principle.dto.UserDTOConverter;
import com.refactor.code.kiss.principle.model.User;
import com.refactor.code.kiss.principle.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ConditionalOnProperty(name = "kiss.principle.enabled", havingValue = "false")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserDTOConverter userDTOConverter;

    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) throws Exception {
        User user = userService.findUserById(id);
        return userDTOConverter.convertToDTO(user);
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        User user = userDTOConverter.convertToEntity(userDTO);
        userService.saveUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return userDTOConverter.convertToDTOList(users);
    }
}

