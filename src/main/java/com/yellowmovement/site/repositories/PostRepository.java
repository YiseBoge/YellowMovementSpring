package com.yellowmovement.site.repositories;

import com.yellowmovement.site.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE CONCAT('%',:keyword,'%') or p.category LIKE CONCAT('%',:keyword,'%') or p.content LIKE CONCAT('%',:keyword,'%') order by p.postedDate desc")
    List<Post> searchPosts(@Param("keyword") String keyword);

    @Query("SELECT p FROM Post p order by p.postedDate desc")
    List<Post> findOrderedPosts();

    @Query("SELECT p.category FROM Post p GROUP BY p.category ORDER BY count(p.category) DESC")
    List<String> findCategoriesList();

}
