package com.yellowmovement.site.repositories;

import com.yellowmovement.site.domains.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
