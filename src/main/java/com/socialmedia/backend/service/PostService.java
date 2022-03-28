package com.socialmedia.backend.service;

import com.socialmedia.backend.model.Post;
import com.socialmedia.backend.model.User;
import com.socialmedia.backend.repository.PostRepository;
import com.socialmedia.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    public List<Post> getPost(){
        return (List<Post>) postRepository.findAll();
    }

    public Post addLike(Long userId,Long postId){
        User liker = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();
        post.addLike(liker);
        return postRepository.save(post);
    }
}
