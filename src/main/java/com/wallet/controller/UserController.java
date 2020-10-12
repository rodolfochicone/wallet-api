package com.wallet.controller;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result){
        Response<UserDTO> response =  new Response<UserDTO>();
        User user = service.save(convertToUserDTOToUser(dto));
        response.setData(convertEntityToDTO(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private User convertToUserDTOToUser(UserDTO dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    private UserDTO convertEntityToDTO(User u){
        return UserDTO.builder()
                .name(u.getName())
                .email(u.getEmail())
                .password(u.getPassword())
                .build();
    }
}
