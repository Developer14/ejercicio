package org.vmdevel.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vmdevel.ejercicio.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //
}
