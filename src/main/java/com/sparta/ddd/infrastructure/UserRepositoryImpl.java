package com.sparta.ddd.infrastructure;

import com.sparta.ddd.domain.entity.user.User;
import com.sparta.ddd.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: JpaRepository 를 Interface 계층에 위시시키는 방법
public interface UserRepositoryImpl extends JpaRepository<User, Long>, UserRepository {
}
