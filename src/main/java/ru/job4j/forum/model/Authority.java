package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String authority;
    @OneToMany(mappedBy = "authority", cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<User> users = new ArrayList<>();

    public Authority() {
    }

    public static Authority of(String authorityName) {
        Authority authority = new Authority();
        authority.setAuthority(authorityName);
        return authority;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public int getId() {
        return id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return id == authority1.id && Objects.equals(authority, authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority);
    }
}
