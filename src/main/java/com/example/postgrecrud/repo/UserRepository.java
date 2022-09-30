package com.example.postgrecrud.repo;

import com.example.postgrecrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
