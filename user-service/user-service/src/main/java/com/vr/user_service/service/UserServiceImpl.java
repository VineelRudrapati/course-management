package com.vr.user_service.service;

import com.vr.user_service.dto.UserRequestDTO;
import com.vr.user_service.dto.UserResponseDTO;
import com.vr.user_service.entity.User;
import com.vr.user_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository =userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user=new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        User saved=userRepository.save(user);
        return mapToRespose(saved);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToRespose(user);
    }


    private UserResponseDTO mapToRespose(User saved) {
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setId(saved.getId());
        userResponseDTO.setName(saved.getName());
        userResponseDTO.setEmail(saved.getEmail());
        return userResponseDTO;

    }
}
