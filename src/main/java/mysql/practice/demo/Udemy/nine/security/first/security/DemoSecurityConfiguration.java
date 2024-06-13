package mysql.practice.demo.Udemy.nine.security.first.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfiguration {

    @Bean
    public SecurityFilterChain theFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers( "/security/**").hasAnyRole("ADMIN","EMPLOYEE")
                                .anyRequest().authenticated()
                ).formLogin(form ->
                        form.loginPage("/ShowMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                ).
                logout(logout -> logout.permitAll()
                ).exceptionHandling(configurer ->
                                configurer.accessDeniedPage("/access-denied")
                );


        return http.build();

    }

}
