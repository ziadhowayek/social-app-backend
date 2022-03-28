package com.socialmedia.backend.repository;

import com.socialmedia.backend.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {

}
