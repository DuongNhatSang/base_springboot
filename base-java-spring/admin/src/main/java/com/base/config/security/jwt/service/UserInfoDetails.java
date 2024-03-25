package com.base.config.security.jwt.service;

import com.base.model.Role;
import com.base.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * UserInfoDetails
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDetails implements UserDetails {

    private String id;

    private String name;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    public UserInfoDetails(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        authorities = getAuthorities(user.getRoles());
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        String[] userRoles = roles.stream().map(Role::getName)
                .toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
