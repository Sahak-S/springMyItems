package com.example.springmyitems.repository;

import com.example.springmyitems.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {


    Optional<User> findByEmail(String email);
    List<User> findAllByName(String name);
    List<User> searchUserByName(String keyword);

//    User findByActivationCode(String code);
//    Page<User> findAll(Pageable pageable);
//    Page<User> findByName(@Param("username") String search);



}
