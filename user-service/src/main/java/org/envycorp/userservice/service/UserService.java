package org.envycorp.userservice.service;

import org.envycorp.userservice.mapper.UserMapper;
import org.envycorp.userservice.model.dto.UserResponseDTO;
import org.envycorp.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::ToDTO).toList();
    }

    public UserResponseDTO getUserById(Long id) {
        return UserMapper.ToDTO(userRepository.findById(id).orElseThrow());
    }

    public Boolean userExists(Long id) {
        return userRepository.existsById(id);
    }
}
