package com.aurora.service;

import com.aurora.model.dto.UserDetailsDTO;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    String createToken(UserDetailsDTO userDetailsDTO);

    String createToken(String subject);

    void refreshToken(UserDetailsDTO userDetailsDTO);

    UserDetailsDTO getUserDetailDTO(HttpServletRequest request);

    void renewToken(UserDetailsDTO userDetailsDTO);
}
