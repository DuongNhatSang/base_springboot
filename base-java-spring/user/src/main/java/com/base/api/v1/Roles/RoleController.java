package com.base.api.v1.Roles;

import com.base.dto.v1.response.DataResponse;
import com.base.service.v1.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/role")
@PreAuthorize("isAuthenticated()")
public class RoleController {
    private final RoleService roleService;

    @ApiOperation("Get Api example")
    @PostMapping("/api-client-example")
    public DataResponse getApiClient() throws Exception {
        return DataResponse.okStatus(roleService.getApiExample());
    }
}
