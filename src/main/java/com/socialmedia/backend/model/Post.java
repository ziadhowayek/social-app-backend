package com.socialmedia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("post")
public class Post {
    @Id
    private Long id;
    private String link;
    private Integer likes;
    private Set<LikesRef> likers = new HashSet<>();
    public Post() {
    }

    public Post(Long id, String link, int likes) {
        this.id = id;
        this.link = link;
        this.likes = likes;
    }
    static Post create(String Link,Integer likes){
        return new Post(null,Link,likes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<LikesRef> getLikers() {
        return likers;
    }

    public void setLikers(Set<LikesRef> likers) {
        this.likers = likers;
    }

    public void addLike(User user){
        this.getLikers().add(new LikesRef(user.getId()));
    }
}
