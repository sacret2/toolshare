package com.mar.toolshare.configuration;

import com.mar.toolshare.service.authentication.TsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    TsUserDetailsService tsUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(tsUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //http.headers().contentSecurityPolicy("script-src 'self' https://trustedscripts.example.com; object-src https://trustedplugins.example.com; report-uri /csp-report-endpoint/");

        http.authorizeRequests()
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/", "/**").permitAll() // access of the home page only for authenticated
                .and().formLogin().loginPage("/login");

        // cross-side request forgery protection - by default by Spring
        //http.csrf().disable();
        //http.headers().frameOptions().disable();
    }
}
