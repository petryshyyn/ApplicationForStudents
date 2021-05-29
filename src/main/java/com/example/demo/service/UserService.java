package com.example.demo.service;

import com.example.demo.model.User;
import com.google.cloud.datastore.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    Datastore datastore;

    private User user;

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

    public String getEmail(String email) {
        Key key = userKeyFactory.newKey(email);
        return datastore.get(key).getString("email");
    }

    public String getFullName(String email) {
        Key key = userKeyFactory.newKey(email);
        return datastore.get(key).getString("firstName") + " " + datastore.get(key).getString("lastName");
    }

    public String getDateOfBird(String email) {
        Key key = userKeyFactory.newKey(email);
        return datastore.get(key).getString("dateOfBird");
    }
   /* public User findByEmail(String email) {
        Key key = userKeyFactory.newKey(email);
        if(user.getEmail().equals(datastore.get(key).getString("email"))){
            return user;
        }
        return null;
    }*/

    public List<User> getAllUsers() {
        Query<Entity> query =
                Query.newGqlQueryBuilder(Query.ResultType.ENTITY, "SELECT * FROM datastore.user").build();
        QueryResults<Entity> results = datastore.run(query);
        List<User> users = new ArrayList<>();
        while (results.hasNext()) {
            Entity result = results.next();
            users.add(
                    new User(result.getString("email"),
                            result.getString("password"),
                            result.getString("firstName"),
                            result.getString("lastName"),
                            result.getString("dateOfBird")));
        }
        return users;
    }

    public User getUser(String email) {
        Entity entity = datastore.get(userKeyFactory.newKey(email));
        return entity == null
                ? null
                : new User(entity.getString("email"),
                entity.getString("password"),
                entity.getString("firstName"),
                entity.getString("lastName"),
                entity.getString("dateOfBird"));
    }
}
