package com.refactor.code.smells.longmethods.controller;

import com.refactor.code.smells.longmethods.model.Order;
import com.refactor.code.smells.longmethods.model.OrderDTO;
import com.refactor.code.smells.longmethods.model.User;
import com.refactor.code.smells.longmethods.model.UserDTO;
import com.refactor.code.smells.longmethods.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Here we are doing simple refactoring in the same class
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        UserDTO userDTO = convertUserToUserDTO(user);
        assignPermissionsToUserDTO(user, userDTO);
        return ResponseEntity.ok(userDTO);
    }

    private static void assignPermissionsToUserDTO(User user, UserDTO userDTO) {
        if (user.getRole().equals("admin")) {
            userDTO.setPermissions(Arrays.asList("CREATE_USER", "DELETE_USER", "EDIT_USER", "VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS"));
        } else if (user.getRole().equals("manager")) {
            userDTO.setPermissions(Arrays.asList("VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS"));
        } else {
            userDTO.setPermissions(Arrays.asList("VIEW_ORDERS", "VIEW_PRODUCTS"));
        }
    }

    private UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        List<Order> orders = user.getOrders();
        userDTO.setOrderDTOs(convertOrdersToOrderDTOs(orders));
        return userDTO;
    }

    private List<OrderDTO> convertOrdersToOrderDTOs(List<Order> orders) {
        return orders.stream().map(UserController::convertOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    private static OrderDTO convertOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setOrderDate(order.getOrderDate());
        return orderDTO;
    }


}

