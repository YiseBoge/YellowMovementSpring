package com.yellowmovement.site.repositories;

import com.yellowmovement.site.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
