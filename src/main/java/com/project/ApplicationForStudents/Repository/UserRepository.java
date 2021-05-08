package com.project.ApplicationForStudents.Repository;


import com.project.ApplicationForStudents.model.User;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface UserRepository extends DatastoreRepository<User, Long> {
    User findByEmail(String username);
}
