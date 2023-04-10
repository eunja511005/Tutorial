package com.eun.tutorial.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eun.tutorial.dto.UserInfoDTO;
import com.eun.tutorial.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyWebInitController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWebInitController.class);
	private final UserService userService;
	
	@Autowired private BCryptPasswordEncoder passwordEncoder; // 시큐리티에서 빈(Bean) 생성할 예정
	
	@GetMapping("/signinInit")
    public ModelAndView signinInit() {
		logger.debug("request url : /signinInit");
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");

        return modelAndView;
    }
	
	@GetMapping("/joinInit")
    public ModelAndView joinInit() {
		logger.debug("request url : /joinInit");
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("join");

        return modelAndView;
    }
	
    @PostMapping("/join")
    public Map join(UserInfoDTO userInfoDTO) {
    	logger.debug("request url : /join");
		userService.addUser(userInfoDTO);
		
		Map<String, String> res = new HashMap<>();
        res.put("result", "registe success");
		return res;
	}
}
