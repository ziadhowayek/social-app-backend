package com.socialmedia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("likes")
public class LikesRef {
    @Id
    private Long user;

    public LikesRef(Long user) {
        this.user = user;
    }

    public Long getUser() {
        return user;
    }
}
