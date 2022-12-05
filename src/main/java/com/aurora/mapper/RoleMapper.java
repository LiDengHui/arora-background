package com.aurora.mapper;

import com.aurora.entity.Role;
import com.aurora.model.dto.ResourceRoleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<ResourceRoleDTO> listResourceRoles();
}
