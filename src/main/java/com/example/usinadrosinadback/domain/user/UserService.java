package com.example.usinadrosinadback.domain.user;

import com.example.usinadrosinadback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.usinadrosinadback.business.Status.ACTIVE;


@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> user = userRepository.findUserBy(username, password, ACTIVE.getLetter());
        return ValidationService.getValidUser(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getReferenceById(userId);
    }

}
