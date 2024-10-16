package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email); // 이메일로 유저 조회
    User findByUsername(String username); // 유저명으로 유저 조회
}
