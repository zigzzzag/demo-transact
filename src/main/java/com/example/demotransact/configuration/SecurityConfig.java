package com.example.demotransact.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
//            .antMatchers(API_V1 + "/agreements/**").permitAll()
//            .antMatchers(API_V1 + "/transactions/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder(12);
        System.out.println("admin: " + pe.encode("admin"));
        System.out.println("user: " + pe.encode("user"));
        //admin: $2a$12$52u7pnI2SsTrIPn.023Loe4XCqVoBEPsnt2X7D6lGSUFyFQrHItzO
        //user: $2a$12$6Lz4ccy8qab8bZxKUkw18erUXpyHlNfC0uxWc1fe9Ygpk32vkDmgC
//        $2y$12$aNcnVeRJ8htZLgYmIr4eDe7PhgRBfn/d7tW2iLMv2avzAxoSflE76
    }
}
