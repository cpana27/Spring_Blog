package com.demo.blog.repository;

import com.demo.blog.entity.UserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<UserName, Long> {
    UserName findAllById(long id);

    Collection<UserName> getAllByIdAfter(long id);

    UserName getUserByUserName(String userName);


}
