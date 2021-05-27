package com.example.demo.repositoty;

import com.example.demo.model.User;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface UserRepository extends DatastoreRepository<User, String> {
    User findByEmail(String email);
}
