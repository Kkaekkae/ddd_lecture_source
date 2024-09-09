package com.sparta.ddd.domain.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

//TODO: DDD를 사용할 경우 access 제한 설정을 권장드립니다.
@Entity
@Table(name = "users")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class User {
    private static final String PHONE_NUMBER_TRANSFER_TARGET = "-";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Boolean isManufacture;
    @CreatedDate
    private LocalDateTime createdAt;

    public static User create(String name, String email, String phoneNumber) {
        User user = User.builder()
                .name(name)
                .email(email)
                .build();
        //TODO: Static Method 로 구현한 규칙의 경우 builder 생성 이후 호출로 구현 가능합니다.
        user.transferPhoneNumberFormat(phoneNumber);
        return user;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //TODO: 객체 수정 시 Domain 에 정해진 규칙을 적용하여 수정하는 방법
    public void update(String name, String email, String phoneNumber) {
        update(name, email);
        transferPhoneNumberFormat(phoneNumber);
    }

    private void transferPhoneNumberFormat(String phoneNumber) {
        this.phoneNumber = phoneNumber.replaceAll(PHONE_NUMBER_TRANSFER_TARGET, "");
    }

    public void changeToManufacture() {
        this.isManufacture = true;
    }

}
