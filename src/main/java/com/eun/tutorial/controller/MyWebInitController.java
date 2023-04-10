package com.eun.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.eun.tutorial.dto.Book;
import com.eun.tutorial.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyWebInitController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWebInitController.class);
	private final BookService bookService;
	
	@GetMapping("/signinInit")
    public ModelAndView viewInit() {
		logger.debug("request url : /");
		
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");

        return modelAndView;
    }
}
