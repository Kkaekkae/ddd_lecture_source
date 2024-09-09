package com.sparta.ddd.application.service;

import com.sparta.ddd.application.dtos.user.SimpleUpdateUserDto;
import com.sparta.ddd.application.dtos.user.UpdateUserDto;
import com.sparta.ddd.application.dtos.user.UserDto;
import com.sparta.ddd.application.dtos.user.UserResponse;
import com.sparta.ddd.domain.entity.user.User;
import com.sparta.ddd.domain.repository.UserRepository;
import com.sparta.ddd.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository orderRepository;

    public UserService(UserRepository userRepository, ProductRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public UserResponse getUser(Long userId) {
        return userRepository.findById(userId).map(UserResponse::of).orElseThrow();
    }

    @Transactional
    public UserResponse createUser(UserDto request) {
        // User 엔티티에 객체 생성에 대한 책임을 부여합니다.
        User user = User.create(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber()
        );

        userRepository.save(user);

        // Dirty Checking 으로 User 엔티티의 Id가 추가되어 반환됩니다.
        return UserResponse.of(user);
    }

    @Transactional
    public UserResponse simpleUpdateUser(Long userId, SimpleUpdateUserDto request) {
        return userRepository.findById(userId).map(user -> {
            user.update(request.getName(), request.getEmail());
            return UserResponse.of(user);
        }).orElseThrow();
    }

    @Transactional
    public UserResponse updateUser(Long userId, UpdateUserDto request) {
        return userRepository.findById(userId).map(user -> {
            user.update(request.getName(), request.getEmail(), request.getPhoneNumber());
            return UserResponse.of(user);
        }).orElseThrow();
    }
}

