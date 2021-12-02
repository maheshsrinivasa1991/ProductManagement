package com.SpringBootExample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootExample.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User save(User user);

	

}
