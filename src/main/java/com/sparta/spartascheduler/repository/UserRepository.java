package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
   Optional<User> findByUsername(String username); // 유저명으로 유저 조회
}
