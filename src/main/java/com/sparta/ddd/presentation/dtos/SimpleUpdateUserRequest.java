package com.sparta.ddd.presentation.dtos;

import com.sparta.ddd.application.dtos.user.SimpleUpdateUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SimpleUpdateUserRequest {
    String name;
    String email;

    public SimpleUpdateUserDto toDTO() {
        return SimpleUpdateUserDto.create(this.name, this.email);
    }
}
