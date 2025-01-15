package com.lms.library_management_system.repo;

import com.lms.library_management_system.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow, Integer> {
}
