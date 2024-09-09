package com.sparta.ddd.domain.repository;

import com.sparta.ddd.domain.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//TODO: Interface 계층에 존재하는 JpaRepository 를 분리하기 위한 Interface 구현 예제
@Repository
public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
}
