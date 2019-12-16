package org.vmdevel.ejercicio.domain;

import javax.persistence.*;

@Table(name = "user_token")
@Entity
public class UserToken {

    @Id
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
    @Column(length = 500)
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
