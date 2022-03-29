package com.socialmedia.backend.service;

import com.socialmedia.backend.model.Post;
import com.socialmedia.backend.model.PostRef;
import com.socialmedia.backend.model.User;
import com.socialmedia.backend.repository.PostRepository;
import com.socialmedia.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    public User addPost(Long userId, Long postId) {
        User poster = userRepository.findById(userId).get();
        Post post = postRepository.findById((postId)).get();
        poster.addPost(post);
        return userRepository.save(poster);
    }
    public Set<Long> getPosts(Long userId){
        Set<Long> postId = new HashSet<Long>();
        User user = userRepository.findById(userId).get();
        for(PostRef postRef: user.getPost()){
            postId.add(postRef.getPost());
        }
        return postId;
    }
    public User follow(Long userId,Long followingId){
        User user = userRepository.findById(userId).get();
        User following = userRepository.findById(followingId).get();
        user.addFollowing(following);
        return userRepository.save(user);
    }
    public User findByUsername(String userName){
        return userRepository.findByUsername(userName);
    }
    public boolean validateUser(@PathVariable String userName,@PathVariable String password){
        User user = this.findByUsername(userName);
        if(user == null) return false;
        return user.getPassword().equals(password);
    }

    public Long getIdByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user.getId();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public String getExtension(String contentType) {
        int lastCharBeforeExtension = contentType.lastIndexOf('/');
        return contentType.substring(lastCharBeforeExtension+1);
    }

    public String addProfilePicture(long userId, MultipartFile image) throws IOException {
        File post = new File("C:/Users/ziadh/Desktop/ziad/project/pictures/"+userId+"."+this.getExtension(image.getContentType()));
        image.transferTo(post);
        return HttpHeaders.ACCEPT;
    }
}
