package org.vmdevel.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vmdevel.ejercicio.domain.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
