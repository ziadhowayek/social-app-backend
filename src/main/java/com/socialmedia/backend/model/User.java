package com.socialmedia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("user")
public class User {
    @Id
    private Long Id;
    private String username;
    private String email;
    private String password;
    private Set<PostRef> post = new HashSet<>();
    private Set<FollowingRef> following = new HashSet<>();
    public User(){

    }

    public User(Long id, String username, String email, String password) {
        Id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    static User create(String username,String email,String password){
        return new User(null,username,email,password);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Set<PostRef> getPost() {
        return post;
    }

    public void setPost(Set<PostRef> post) {
        this.post = post;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void addPost(Post post){
        this.post.add(new PostRef(post.getId()));
    }

    public Set<FollowingRef> getFollowing() {
        return following;
    }

    public void setfollowing(Set<FollowingRef> followers) {
        this.following = followers;
    }
    public void addFollowing(User user){
        this.getFollowing().add(new FollowingRef(user.Id));
    }
}
