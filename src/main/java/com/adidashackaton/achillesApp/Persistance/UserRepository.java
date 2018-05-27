package com.adidashackaton.achillesApp.Persistance;

import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(int id);
}
