package com.martinbugar.springsecurityjpamysql.repositories;

import com.martinbugar.springsecurityjpamysql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional <User> findByUserName(String username); // na zaklade username najde vsetky parametre v tabulke user v databaze MySql
}
