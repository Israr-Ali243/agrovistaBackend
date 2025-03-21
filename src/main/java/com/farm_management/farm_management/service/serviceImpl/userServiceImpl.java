package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.service.*;
import com.farm_management.farm_management.DTO.UserDTO;
import com.farm_management.farm_management.entity.User;
import com.farm_management.farm_management.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.farm_management.farm_management.repository.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userRepository userRepository;
    @Autowired
    private emailService emailService;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public UserDTO registerUser(User user) {
        String encryptPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
        user.setPassword(encryptPassword);
        user.setCreated_at(new Date());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Welcome to Agrovista – Your Journey to Smarter Farming Begins Here!");
        String body = buildEmailBody(user.getUsername(), user.getEmail(), user.getEmail());
        simpleMailMessage.setText(body);
        mailSender.send(simpleMailMessage);
        return UserToUserDTO(userRepository.save(user));

    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<User> user= userRepository.findById(Long.valueOf(id));
        if (user.isPresent()){
           User user1 = user.get();
            return UserToUserDTO(user1);
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::UserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Optional<User> orginalUser = userRepository.findById(Long.valueOf(userDTO.getId()));
        if (orginalUser.isPresent()){
            User updatedUser = orginalUser.get();
            updatedUser.setEmail(userDTO.getEmail());
            updatedUser.setRole(userDTO.getRole());
            updatedUser.setEnabled(userDTO.getEnabled());
            updatedUser.setUsername(userDTO.getUsername());
            updatedUser.setUpdated_at(new Date());
            return UserToUserDTO(userRepository.save(updatedUser));
        }

        return null;
    }

    public User DtoTOUser(UserDTO userDTO){
        if (userDTO ==null )
            return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setEnabled(userDTO.getEnabled());
        user.setUsername(user.getUsername());
        return user;

    }

    public UserDTO UserToUserDTO(User user){
        if (user==null)
            return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setEnabled(user.getEnabled());
        userDTO.setRole(user.getRole());
        return userDTO;

    }

    private String buildEmailBody(String firstName, String username, String email) {
        return "Dear " + firstName + ",\n\n" +
                "Welcome to Agrovista! We’re thrilled to have you as part of our growing community of innovative farmers and agricultural enthusiasts.\n\n" +
                "Your account has been successfully created, and you are now ready to explore the tools and resources designed to help you manage and optimize your farming operations.\n\n" +
                "Here’s what you can do next:\n\n" +
                "- Explore Your Dashboard\n" +
                "  Get a comprehensive overview of your farm with real-time insights.\n\n" +
                "- Leverage Our Advanced Tools\n" +
                "  Utilize the Rice Disease Prediction System, Multilingual Chatbot, and Farm Management Solution to make data-driven decisions.\n\n" +
                "- Access Resources and Support\n" +
                "  Browse our knowledge base or connect with our support team to get answers to any questions you may have.\n\n" +
                "Need help getting started?\n" +
                "We’ve prepared a quick start guide to help you make the most of Agrovista’s features. Check it out here: [Link to Quick Start Guide]\n\n" +
                "If you have any questions, feel free to reach out to us at support@agrovista.com. We’re here to help!\n\n" +
                "Thank you for choosing Agrovista. Together, we’re driving innovation in agriculture.\n\n" +
                "Best regards,\n" +
                "The Agrovista Team\n\n" +
                "Email: support@agrovista.com\n" +
                "Website: www.agrovista.com\n\n" +
                "User Account Info:\n" +
                "Username: " + username + "\n" +
                "Email: " + email + "\n\n" +
                "Important Links:\n" +
                "- Login to Your Account\n" +
                "- Agrovista Help Center\n\n" +
                "Follow us:\n" +
                "Stay updated with the latest tips and features. Follow us on Facebook | Twitter | Instagram.";
    }
}
