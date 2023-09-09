package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/03/20
 * Time: 06.31
 */
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String roles;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pengguna> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role1)) return false;

        if (getId() != null ? !getId().equals(role1.getId()) : role1.getId() != null) return false;
        if (getRoles() != null ? !getRoles().equals(role1.getRoles()) : role1.getRoles() != null) return false;
        return getUsers() != null ? getUsers().equals(role1.getUsers()) : role1.getUsers() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }
}
