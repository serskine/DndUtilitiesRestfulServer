package com.soupthatisthick.dnd.utilities.server.spring;

import com.soupthatisthick.dnd.utilities.server.security.DndUtilServerAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DndUtilServerAuthenticationProvider dndUtilAuthenticationProvider;

    @Value("${server.environment}")
    private String environment;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(dndUtilAuthenticationProvider);
    }
}
