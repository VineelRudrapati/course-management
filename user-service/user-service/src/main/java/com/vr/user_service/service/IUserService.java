package com.vr.user_service.service;

import com.vr.user_service.dto.UserRequestDTO;
import com.vr.user_service.dto.UserResponseDTO;

public interface IUserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO getUserById(Long id);

}
