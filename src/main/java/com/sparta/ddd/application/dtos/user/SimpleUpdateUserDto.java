package com.sparta.ddd.application.dtos.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(access = AccessLevel.PRIVATE)
public class SimpleUpdateUserDto {
    private String name;
    private String email;

    public static SimpleUpdateUserDto create(String name, String email) {
        return SimpleUpdateUserDto.builder()
                .name(name)
                .email(email)
                .build();
    }
}
