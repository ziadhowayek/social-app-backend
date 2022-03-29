package com.socialmedia.backend.controller;

import com.socialmedia.backend.model.User;
import com.socialmedia.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    @PostMapping("{userId}/addProfilePicture/")
    String addProfilePicture(@PathVariable long userId,@RequestParam("image") MultipartFile image) throws IOException {
        return userService.addProfilePicture(userId,image);
    }

}
