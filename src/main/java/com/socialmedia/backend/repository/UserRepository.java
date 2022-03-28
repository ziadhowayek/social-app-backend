package com.socialmedia.backend.repository;

import com.socialmedia.backend.model.Post;
import com.socialmedia.backend.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query("select * from user where username = :username")
    User findByUsername(@Param("username") String username);

}
