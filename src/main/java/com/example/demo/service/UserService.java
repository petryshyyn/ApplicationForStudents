package com.example.demo.service;

import com.example.demo.model.User;
import com.google.cloud.datastore.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    Datastore datastore;

    private KeyFactory userKeyFactory;

    @PostConstruct
    public void initializeKeyFactories() {
        userKeyFactory = datastore.newKeyFactory().setProjectId("lyrical-gantry-314214").setNamespace("datastore").setKind("user");
    }

    public Entity createUser(User user) {
        return datastore.put(createUserEntity(user));
    }

    private Entity createUserEntity(User user) {
        Key key = userKeyFactory.newKey(user.getEmail());
               return Entity.newBuilder(key)
                .set("email", user.getEmail())
                .set("password", user.getPassword())
                .set("firstName", user.getFirstName())
                .set("lastName", user.getLastName())
                .set("dateOfBird", user.getDateOfBirth())
                .build();
    }

    @Async
    public void updateUser(String id, User user) {
    }

    @Async
    public void deleteUser(String id) {
        //
    }
}
