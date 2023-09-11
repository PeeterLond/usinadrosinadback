package com.example.usinadrosinadback.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;
    public Role getRole() {
        int clientRoleId = 2;
        return roleRepository.getReferenceById(clientRoleId);
    }
}
