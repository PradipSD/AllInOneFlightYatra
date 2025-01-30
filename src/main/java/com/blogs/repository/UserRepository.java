package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.pojos.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
