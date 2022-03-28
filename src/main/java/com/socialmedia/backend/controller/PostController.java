package com.socialmedia.backend.controller;

import com.socialmedia.backend.model.Post;
import com.socialmedia.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    List<Post> getPost(){
        return postService.getPost();
    }

    @PutMapping("{userId}/like/{postId}")
    Post addLike(@PathVariable Long userId,@PathVariable Long postId){
        return postService.addLike(userId,postId);
    }
}
