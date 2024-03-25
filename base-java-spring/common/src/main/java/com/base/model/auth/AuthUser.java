package com.base.model.auth;

import com.base.enums.AuthUserEnum;
import com.base.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_users")
@Builder
public class AuthUser extends BaseAuthModel {

    @Id
    @Column
    private String id;
    private String name;
    private String email;
    private String phone;
    private Instant birthday;
    private String address;
    private Instant emailVerifiedAt;
    private String parentId;
    private int status;
    private int isSync;

    @OneToMany(mappedBy = "authUser", cascade = CascadeType.MERGE)
    @JsonBackReference
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;

    public Boolean isBlocked() {
        return AuthUserEnum.Status.BLOCKED.getCode().equals(this.status);
    }

    public Boolean isInActive() {
        return AuthUserEnum.Status.INACTIVE.getCode().equals(this.status);
    }
}
