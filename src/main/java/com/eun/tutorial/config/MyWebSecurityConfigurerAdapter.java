package com.eun.tutorial.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity //스프링시큐리티 사용을 위한 어노테이션선언
@RequiredArgsConstructor
@Slf4j
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { // http 관련 인증 설정
        /**
         * 특정 URL에 대해 csrf 토큰 체크 안하도록 설정, 
         * 기본으로 Get은 체크하지 않음, 
         * Post/Put일때는 꼭 csrf 토큰 사용 할 것
         * javascript에서 CSRF 토큰을 사용하가 위해 httpOnlyFalse()로 지정
         */
        http.csrf()
        	.ignoringAntMatchers("/logout/**")
        	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    	
        /**
         * 1.세션 관련 설정
         *   1) 필요시 세션 생성
         *   2) session fixation 공격 방지를 위해 로그인 시 신규 세션 생성
         *   3) 유효하지 않은 세션으로 접속 시도 시 리다이렉션 페이지 설정
         *   4) 1명의 유저별로 동시 접속 가능한 세션 수 설정
         *   5) 동시 접속 가능한 세션 수 초과 시 접속 불가 설정
         *   6) 세션 만료시 리다이렉션 페이 설정
         *   7) 세션 레지스터리 설정
         */
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation().newSession()
//                .invalidSessionUrl("/invalidSession.html")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true)
                .expiredUrl("/sessionExpire.html")
                .sessionRegistry(sessionRegistry());
        
        http
        .authorizeRequests() // 접근에 대한 인증 설정
            .antMatchers("/signin", "/assets/**", "/sign-in.css", "/joinForm", "/join", "/h2-console/**", "/error/**", "/favicon.ico", "/layout/test").permitAll() // 누구나 접근 허용
            .anyRequest().authenticated();
        
        /**
         * 5.로그인 설정
         *   1) 로그인 페이지 설정
         *   2) 로그인 페이지에서 로그인을 위해 호출 하는 url 설정
         *   3) 나머지는 인증 후 접속 가능토록 설정
         *   4) 로그인 성공시 핸들러 설정
         *   5) 로그인 실패시 핸들서 설정
         *   6) 모두 로그 아웃에 접근 가능
         */
        http
                .formLogin() // 로그인에 관한 설정
                    .loginPage("/signin") // 로그인 페이지 URL 
//                    .loginProcessingUrl("/login")
//                	.usernameParameter("userId")
                    .successHandler((request, response, auth)->{
                        for (GrantedAuthority authority : auth.getAuthorities()){
                            log.info("Authority Information {} ", authority.getAuthority());
                        }
                        log.info("getName {} ",auth.getName());
                        Map<String, String> res = new HashMap<>();
                        response.sendRedirect("/");
                        
//                      Map<String, String> res = new HashMap<>();
//                        res.put("result", "login success");
//                        JSONObject json =  new JSONObject(res);
//                        response.setContentType("application/json; charset=utf-8");
//                        response.getWriter().print(json);
                    })
                    .failureHandler((request, response, exception)->{
                        String errMsg = "";
                        if(exception.getClass().isAssignableFrom(BadCredentialsException.class)){
                            errMsg = "Invalid username or password";
                            //response.setStatus(401);
                        }else{
                            errMsg = "UnKnown error - "+exception.getMessage();
                            //response.setStatus(400);
                        }
//                        zthmErrorRepository.save(ZthmError.builder()
//                                .errorMessage("Login Error : "+exception.getMessage())
//                                .build());
//                        Map<String, String> res = new HashMap<>();
//                        res.put("result", errMsg);
//                        JSONObject json =  new JSONObject(res);
//                        response.setContentType("application/json; charset=utf-8");
//                        response.getWriter().print(json);
                        response.sendRedirect("/login");
                    })
                    .permitAll();        
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }
}