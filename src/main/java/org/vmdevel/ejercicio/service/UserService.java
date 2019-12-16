package org.vmdevel.ejercicio.service;

import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.exception.RegisteredEmailException;

public interface UserService {

    User createUser(User user) throws RegisteredEmailException;
    User updateUser(User user);
}
