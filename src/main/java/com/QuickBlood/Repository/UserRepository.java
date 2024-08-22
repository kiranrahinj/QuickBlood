package com.QuickBlood.Repository;

import com.QuickBlood.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByName(String name);
    @Query("from User u where u.bloodType=?1")
    List<User> findByBloodType(String bloodType);
    List<User> findByBloodTypeAndLocation(String bloodType,String location);
}
