package com.socialmedia.backend.controller;

import com.socialmedia.backend.model.Post;
import com.socialmedia.backend.model.PostRef;
import com.socialmedia.backend.model.User;
import com.socialmedia.backend.repository.PostRepository;
import com.socialmedia.backend.repository.UserRepository;
import com.socialmedia.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("/")
    List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping("/{userName}")
    User getUserName(@PathVariable String userName){
        return userService.findByUsername(userName);
    }

    @GetMapping("/getId/{username}")
    Long getIdbyUsername(@PathVariable String username){
        return userService.getIdByUsername(username);
    }

    @GetMapping("/getUser/{userId}")
    User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/user={userName}/password={password}")
    boolean validateUser(@PathVariable String userName,@PathVariable String password){
        return userService.validateUser(userName,password);
    }

    @PutMapping("/{userId}/post/{postId}")
    User addPost(@PathVariable Long userId,@PathVariable Long postId){
        return userService.addPost(userId,postId);
    }

    @PutMapping("/{userId}/follow/{followingId}")
    User follow(@PathVariable Long userId,@PathVariable Long followingId){
        return userService.follow(userId,followingId);
    }



}
