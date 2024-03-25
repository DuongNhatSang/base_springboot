package com.base.config.security.jwt.service;

import com.base.model.Role;
import com.base.model.User;
import com.base.repository.CommonRoleRepository;
import com.base.repository.CommonUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * UserDetailsServiceImpl
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CommonUserRepository userRepository;

    @Autowired
    private CommonRoleRepository commonRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndDeletedAtIsNull(username)
                .orElseThrow(() -> new  UsernameNotFoundException("User not found"));
        return new UserInfoDetails(user);
    }

    public UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserIdAndDeletedAtIsNull(userId)
                .orElseThrow(() -> new  UsernameNotFoundException("User not found"));
        List<Role> roleList = commonRoleRepository.findAllRolesByUserIds(user.getId());
        user.setRoles(roleList);
          return new UserInfoDetails(user);
    }
}
