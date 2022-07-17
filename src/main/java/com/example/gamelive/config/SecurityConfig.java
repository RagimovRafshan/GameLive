package com.example.gamelive.config;

import com.example.gamelive.model.entity.User;
import com.example.gamelive.model.entity.enums.Role;
import com.example.gamelive.service.abstr.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
@ComponentScan("com.example.gamelive")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UsersService usersService;
    private LoginSuccessHandler loginSuccessHandler;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(13);

    @Autowired
    public SecurityConfig(UsersService userDetailsService, LoginSuccessHandler loginSuccessHandler) {
        this.usersService = userDetailsService;
        this.loginSuccessHandler = loginSuccessHandler;
    }

//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .successHandler(loginSuccessHandler)
                .permitAll();

        http
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
                .and().csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/login").anonymous();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(usersService);
        return authenticationProvider;
    }

//    @PostConstruct
    public void createworkSpace() {
        User rafshan = User
                .builder()
                .role(Role.ADMIN)
                .password(passwordEncoder.encode("password_of_rafshan"))
                .username("rageeemow.rafshhan@gmail.com")
                .build();
        User konstantin = User
                .builder()
                .role(Role.ADMIN)
                .password(passwordEncoder.encode("password_of_Konstantin"))
                .username("Yurt.Konstantin@gmail.com")
                .friends(
                        Stream
                                .of(rafshan)
                                .toList())
                .build();
        usersService.save(rafshan);
        usersService.save(konstantin);
    }
}
