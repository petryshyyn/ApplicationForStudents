package com.project.ApplicationForStudents.Repository;


import com.project.ApplicationForStudents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
