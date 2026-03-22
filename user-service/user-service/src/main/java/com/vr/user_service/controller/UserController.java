package com.vr.user_service.controller;
import com.vr.user_service.dto.UserRequestDTO;
import com.vr.user_service.dto.UserResponseDTO;
import com.vr.user_service.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service)
    {
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody @Valid UserRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.createUser(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(
            @PathVariable Long id)
    {
        return ResponseEntity.ok(service.getUserById(id));
    }

}
