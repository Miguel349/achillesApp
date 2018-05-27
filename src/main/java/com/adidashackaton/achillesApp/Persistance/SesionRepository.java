package com.adidashackaton.achillesApp.Persistance;

import com.adidashackaton.achillesApp.pojos.Sesion;
import com.adidashackaton.achillesApp.pojos.User;
import com.adidashackaton.achillesApp.pojos.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {
    public Sesion findByUser(User user);

}
