package com.aurora.handler;

import com.aurora.mapper.RoleMapper;
import com.aurora.model.dto.ResourceRoleDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource  {

    private RoleMapper roleMapper;

    private static List<ResourceRoleDTO> resourceRoleDTOList;

    @PostConstruct
    private void loadResourceRoleList() {
        resourceRoleDTOList = roleMapper.listResourceRoles();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        if(CollectionUtils.isEmpty(resourceRoleDTOList)) {
            this.loadResourceRoleList();
        }
        FilterInvocation fi = (FilterInvocation) object;

        String method = fi.getRequest().getMethod();

        String url = fi.getRequest().getRequestURI();

        AntPathMatcher antPathMatcher = new AntPathMatcher();


        for(ResourceRoleDTO resourceRoleDTO: resourceRoleDTOList) {
            if(antPathMatcher.match(resourceRoleDTO.getUrl(), url) && resourceRoleDTO.getRequestMethod().equals(method)) {
                List<String> roleList = resourceRoleDTO.getRoleList();

                if(CollectionUtils.isEmpty(roleList)) {
                    return SecurityConfig.createList("disabled");
                }
                return SecurityConfig.createList(roleList.toArray(new String[]{}));
            }
        }

        return SecurityConfig.createList("disable");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
