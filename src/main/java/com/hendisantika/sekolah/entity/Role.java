package com.hendisantika.sekolah.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

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

    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pengguna> users;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role1)) return false;

        if (getId() != null ? !getId().equals(role1.getId()) : role1.getId() != null) return false;
        if (getRole() != null ? !getRole().equals(role1.getRole()) : role1.getRole() != null) return false;
        return getUsers() != null ? getUsers().equals(role1.getUsers()) : role1.getUsers() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
        return result;
    }
}
