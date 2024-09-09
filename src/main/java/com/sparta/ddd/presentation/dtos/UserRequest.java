package com.sparta.ddd.presentation.dtos;

import com.sparta.ddd.application.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String email;
    private String phoneNumber;

    //TODO: UserInterface 계층과 Application 계층간 Object 분리 방법
    public UserDto toDTO() {
        return UserDto.create(this.username, this.email, this.phoneNumber);
    }
}
