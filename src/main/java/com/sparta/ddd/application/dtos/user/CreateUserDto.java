package com.sparta.ddd.application.dtos.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class CreateUserDto {
    private String name;
    private String email;
    private String phoneNumber;

    public static CreateUserDto create(String name, String email, String phoneNumber) {
        return CreateUserDto.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
