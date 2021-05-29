package com.example.demo.details;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private static User userInfo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser(email);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
        }
            userInfo = new User(user.getEmail(), user.getPassword() ,user.getFirstName(), user.getLastName(), user.getDateOfBirth());
        return new StudentDetails(user);
    }

    public static User getUserInfo(){
        return userInfo;
    }
}
