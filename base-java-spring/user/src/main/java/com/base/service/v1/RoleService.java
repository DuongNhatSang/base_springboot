package com.base.service.v1;

import com.base.feign.ApiClientExample;
import com.base.model.Role;
import com.base.repository.CommonRoleRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final CommonRoleRepository commonRoleRepository;

    private final ApiClientExample apiClientExample;

    public List<Role> getRolesList() {
        return commonRoleRepository.findAllRoles();
    }

    public String getApiExample() {
        try {
            ResponseEntity<String> result = apiClientExample.apiExample();
            return result.getBody();
        } catch (FeignException e) {
            return null;
        }
    }
}
