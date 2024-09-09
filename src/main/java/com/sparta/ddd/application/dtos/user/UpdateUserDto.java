package com.sparta.ddd.application.dtos.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class UpdateUserDto {
    private String name;
    private String email;
    private String phoneNumber;

    public static UpdateUserDto create(String name, String email, String phoneNumber) {
        return UpdateUserDto.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
