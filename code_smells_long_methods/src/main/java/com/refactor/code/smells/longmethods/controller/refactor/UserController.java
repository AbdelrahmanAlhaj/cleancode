package com.refactor.code.smells.longmethods.controller.refactor;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.longmethods.model.User;
import com.refactor.code.smells.longmethods.model.UserDTO;
import com.refactor.code.smells.longmethods.refactor.UserDTOConverter;
import com.refactor.code.smells.longmethods.refactor.UserPermission;
import com.refactor.code.smells.longmethods.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserDTOConverter userDTOConverter;

    public UserController(UserRepository userRepository, UserDTOConverter userDTOConverter) {
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        UserDTO userDTO = userDTOConverter.convert(user);

        UserPermission userPermission = userDTOConverter.assignUserPermissions(user.getRole());
        userDTO.setPermissions(userPermission.getPermissions());

        return ResponseEntity.ok(userDTO);
    }
}
