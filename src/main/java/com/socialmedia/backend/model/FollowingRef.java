package com.socialmedia.backend.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("follow")
public class FollowingRef {
    private Long following;

    public FollowingRef(Long following) {
        this.following = following;
    }

    public Long getFollowing() {
        return following;
    }
}
