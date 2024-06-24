package com.carInfo.carShowroom.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)

	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from member where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from role where user_id=?");


        return jdbcUserDetailsManager;
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/cars").hasAnyRole("MANAGER", "EMPLOYEE", "CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/inventory-managers").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/customers").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/inventory").hasAnyRole("MANAGER", "EMPLOYEE", "CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/purchase-details").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/salespersons").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/members").hasAnyRole("MANAGER", "EMPLOYEE")


                   

                        .requestMatchers(HttpMethod.GET, "/cars/**").hasAnyRole("MANAGER", "EMPLOYEE", "CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/inventory-managers/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/customers/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/inventory/**").hasAnyRole("MANAGER", "EMPLOYEE", "CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/purchase-details/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/salespersons/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/members/**").hasAnyRole("MANAGER", "EMPLOYEE")

                        .requestMatchers(HttpMethod.POST, "/cars").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/inventory-managers").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/customers").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/inventory").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/purchase-details").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/salespersons").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/members").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/members/manager").hasAnyRole("MANAGER")

                        .requestMatchers(HttpMethod.PUT, "/cars/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/inventory-managers/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/customers/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/inventory/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/purchase-details/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/salespersons/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/members").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/members/**").hasAnyRole("MANAGER")

                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/inventory-managers/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/customers/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/inventory/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/purchase-details/**").hasAnyRole("MANAGER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/salespersons/**").hasAnyRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/members").hasAnyRole("MANAGER")

                       
                       
                        

                   
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}














