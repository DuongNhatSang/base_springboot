package com.base.model;

import com.base.model.auth.AuthUser;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
@Builder
public class User extends BaseModel {

    @Column(length = 150)
    private String name;

    @Email
    private String email;

    @Column(nullable = false, name = "user_name")
    private String username;

    private String password;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    @JsonManagedReference
    private AuthUser authUser;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

}
