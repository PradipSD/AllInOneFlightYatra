package com.blogs.service;

import com.blogs.dto.UserDTO;
import com.blogs.pojos.Role;
import com.blogs.pojos.User;
import com.blogs.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // Set role as USER
        userDTO.setRole(Role.USER);

        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO createAdmin(UserDTO userDTO) {
        // Set role as ADMIN
        userDTO.setRole(Role.ADMIN);

        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        return modelMapper.map(user, UserDTO.class);
    }
    
    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(u -> modelMapper.map(u, UserDTO.class)); // Correct way
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setFname(userDTO.getFname());
        user.setLname(userDTO.getLname());
        user.setPhoneNo(userDTO.getPhoneNo());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateAdmin(Long id, UserDTO userDTO) {
        User admin = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        
        admin.setFname(userDTO.getFname());
        admin.setLname(userDTO.getLname());
        admin.setPhoneNo(userDTO.getPhoneNo());
        admin.setEmail(userDTO.getEmail());
        admin.setPassword(userDTO.getPassword());

        User updatedAdmin = userRepository.save(admin);
        return modelMapper.map(updatedAdmin, UserDTO.class);
    }

    
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public void deleteAdmin(Long id) {
        User admin = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        userRepository.delete(admin);
    }
}
