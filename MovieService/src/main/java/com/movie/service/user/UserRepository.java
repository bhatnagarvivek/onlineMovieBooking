
package com.movie.service.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}