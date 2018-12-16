package com.yellowmovement.site.repositories;

import com.yellowmovement.site.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    
}
