package com.lms.library_management_system.repo;

import com.lms.library_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
