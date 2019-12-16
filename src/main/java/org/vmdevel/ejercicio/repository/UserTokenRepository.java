package org.vmdevel.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vmdevel.ejercicio.domain.UserToken;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Integer> {
}
