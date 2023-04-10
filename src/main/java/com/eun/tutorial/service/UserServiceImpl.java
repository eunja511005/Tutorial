package com.eun.tutorial.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eun.tutorial.controller.MyWebInitController;
import com.eun.tutorial.dto.UserInfoDTO;
import com.eun.tutorial.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserMapper userDao;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired private BCryptPasswordEncoder passwordEncoder; // 시큐리티에서 빈(Bean) 생성할 예정
	

//	@Override
//	public Collection<UserInfoDTO> getUsers() {
//		return testDao.getUserLists();
//	}

	@Override
	public UserInfoDTO addUser(UserInfoDTO userInfoDTO) {
		userInfoDTO.setCreateId(userInfoDTO.getUsername());
		userInfoDTO.setUpdateId(userInfoDTO.getUsername());
		userInfoDTO.setEnable(true);
		userInfoDTO.setPassword(passwordEncoder.encode(userInfoDTO.getPassword()));

		int result = userDao.addUser(userInfoDTO);
		return userInfoDTO;
	}

}
