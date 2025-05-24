package com.alvirg.barterexchange.Features.Users;

import com.alvirg.barterexchange.Shared.Domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String fullName;

    private boolean active;


    @Builder
    public UserEntity(int id,
                      String username,
                      String email,
                      String password,
                      String fullName,
                      boolean active) {
        super(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.active = active;
    }


}

