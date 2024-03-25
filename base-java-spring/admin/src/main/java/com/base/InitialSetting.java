package com.base;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.base.config.ApplicationProperties;
import com.base.model.UserRole;
import com.base.repository.CommonUserRoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.base.model.User;
import com.base.repository.CommonRoleRepository;
import com.base.repository.CommonUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialSetting implements InitializingBean {
    private final CommonUserRepository userRepository;
    private final CommonRoleRepository roleRepository;
    private final CommonUserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;
    private final ApplicationProperties properties;

    @Override
    public void afterPropertiesSet() {
        initRootInfo();
    }

    private void initRootInfo() {
        Optional<User> opt = this.userRepository.findByEmail(properties.getRoot().getEmail());
        var roles = roleRepository.findAllRoles();

        if (!opt.isPresent()) {
            User user = new User();
            user.setId("00000000-0000-0000-0000-000000000000");
            user.setEmail(properties.getRoot().getEmail());
            user.setUsername(user.getEmail());
            user.setName("Root Admin");
            user.setPassword(passwordEncoder.encode(properties.getRoot().getPassword()));
            user.setCreatedAt(Instant.now());
            user.setUpdatedAt(Instant.now());
            this.userRepository.insertUser(user);

            roles.forEach(
                    role -> {
                        userRoleRepository.insertUserRole(
                                new UserRole(UUID.randomUUID().toString(), role.getId(), user.getId()));
                    }
            );
        }
    }
}
