package com.socialmedia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("post_user")
public class PostRef {
    @Id
    private Long post;

    public PostRef(Long post) {
        this.post = post;
    }

    public Long getPost() {
        return post;
    }
}
