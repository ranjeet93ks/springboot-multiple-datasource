package com.javatechie.multiple.ds.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.multiple.ds.user.entity.User;

@Repository
public interface UserMySqlRepository extends JpaRepository<User, Integer> {

}
