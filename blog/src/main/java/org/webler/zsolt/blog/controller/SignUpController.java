package org.webler.zsolt.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webler.zsolt.blog.controller.dto.SignUpRequest;
import org.webler.zsolt.blog.model.Role;
import org.webler.zsolt.blog.model.User;
import org.webler.zsolt.blog.repository.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity signUp(@RequestBody @Valid SignUpRequest request) throws JsonProcessingException {

        try {
            assertPasswordsMatch(request);
            userRepository.findByUsernameIgnoreCaseOrEmailIgnoreCase(request.getUsername(), request.getEmail())
                    .ifPresent((user) -> {
                        throw new RuntimeException("Username or email is already taken!");
                    });


        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        user.addRole(Role.builder()
                .role("USER")
                .build());

        userRepository.save(user);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void assertPasswordsMatch(SignUpRequest request) {
        if (!request.getPassword().equals(request.getPasswordAgain())) {
            throw new ValidationException("Passwords didn't match!");
        }
    }

}
