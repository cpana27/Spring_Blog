package com.demo.blog.repository;

import com.demo.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllById(long id);
    Collection<User> getAll();
    User getUserByUserName(String userName);


}
