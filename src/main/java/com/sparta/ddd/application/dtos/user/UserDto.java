package com.sparta.ddd.application.dtos.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class UserDto {
    private String name;
    private String email;
    private String phoneNumber;

    //TODO: Static Method 사용 예시
    public static UserDto create(String name, String email, String phoneNumber) {
        return UserDto.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
