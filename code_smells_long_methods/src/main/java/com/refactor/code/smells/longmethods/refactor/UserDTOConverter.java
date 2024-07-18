package com.refactor.code.smells.longmethods.refactor;

import com.refactor.code.smells.longmethods.model.OrderDTO;
import com.refactor.code.smells.longmethods.model.User;
import com.refactor.code.smells.longmethods.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDTOConverter implements Converter<User, UserDTO> {

    private final OrderDTOConverter orderDTOConverter;

    public UserDTOConverter(OrderDTOConverter orderDTOConverter) {
        this.orderDTOConverter = orderDTOConverter;
    }

    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());
        List<OrderDTO> orderDTOs = orderDTOConverter.convert(user.getOrders());
        userDTO.setOrderDTOs(orderDTOs);
        return userDTO;
    }

    public UserPermission assignUserPermissions(String role) {
        UserPermission permission;
        if (role.equals("admin")) {
            permission = new AdminPermission();
        } else if (role.equals("manager")) {
            permission = new ManagerPermission();
        } else {
            permission = new RegularUserPermission();
        }
        return permission;
    }

}
