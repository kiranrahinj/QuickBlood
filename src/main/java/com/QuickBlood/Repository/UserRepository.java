package com.QuickBlood.Repository;

import com.QuickBlood.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByMobileNumber(String mobileNymber);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByBloodType(String bloodType);
    List<User> findByBloodTypeAndLocation(String bloodType,String location);
}
