package com.eun.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity //스프링시큐리티 사용을 위한 어노테이션선언
@RequiredArgsConstructor
@Slf4j
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
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
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }
}