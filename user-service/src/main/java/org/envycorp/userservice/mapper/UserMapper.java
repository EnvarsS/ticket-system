package org.envycorp.userservice.mapper;


import org.envycorp.userservice.model.dto.UserResponseDTO;
import org.envycorp.userservice.model.entity.User;

public class UserMapper {
    public static UserResponseDTO ToDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
