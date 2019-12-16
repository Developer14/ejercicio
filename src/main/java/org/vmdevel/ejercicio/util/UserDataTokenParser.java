package org.vmdevel.ejercicio.util;

import org.vmdevel.ejercicio.domain.User;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author KDU
 * @version 1.0.0
 * @since 1.0.0
 */
public class UserDataTokenParser {

    /**
     *
     * @param user
     * @return
     */
    public static Consumer<Map<String, Object>> setTokenClaims(User user) {
        return claims -> {
            claims.put("nombreUsuario", user.getName());
            claims.put("emailUsuario", user.getEmail());
        };
    }

}
