package com.prasanna.ecommerceproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasanna.ecommerceproject.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

	Optional<UserEntity> findByUserName(String name);
}
