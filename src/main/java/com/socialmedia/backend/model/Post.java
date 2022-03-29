package com.socialmedia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("post")
public class Post {
    @Id
    private Long id;
    private byte[] data;
    private Integer likes;
    private Set<LikesRef> likers = new HashSet<>();
    public Post() {
    }

    public Post(Long id, byte[] data, int likes) {
        this.id = id;
        this.data = data;
        this.likes = likes;
    }
    static Post create(byte[] data,Integer likes){
        return new Post(null,data,likes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
