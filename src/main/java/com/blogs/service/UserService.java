package com.blogs.service;

import java.util.List;
import java.util.Optional;

import com.blogs.dto.UserDTO;
//import com.blogs.pojos.User;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO createAdmin(UserDTO userDTO);

    UserDTO getUserById(Long id);

    Optional<UserDTO> getUserByEmail(String email);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserDTO userDTO);

    UserDTO updateAdmin(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    void deleteAdmin(Long id);

}
