package mysql.practice.demo.Udemy.six.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    in memory credential
/*

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails gaurd = User.builder()
                .username("gaurd")
                .password("{noop}test")
                .roles("GUARD")
                .build();
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test")
                .roles("EMPLOYEE")
                .build();

        UserDetails verma = User.builder()
                .username("verma")
                .password("{noop}test")
                .roles("EMPLOYEE", "MANAGER")
                .build();


        UserDetails singh = User.builder()
                .username("singh")
                .password("{noop}test")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return  new InMemoryUserDetailsManager(john, verma, singh);
    }
*/
//    default spring table
   /* @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws  Exception {
            http.authorizeHttpRequests(configurar->
                    configurar
                            .requestMatchers(HttpMethod.GET,"/udemy/employee/services/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/udemy/employee/services/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST,"/udemy/employee/services/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT,"/udemy/employee/services/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"/udemy/employee/services/employees/**").hasRole("ADMIN")
            );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();

    }*/

    //    custom table
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from member_security where user_id=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role  from roles_security where user_id=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurar ->
                configurar
                        .requestMatchers(HttpMethod.GET, "/udemy/employee/services/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/udemy/employee/services/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/udemy/employee/services/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/udemy/employee/services/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/udemy/employee/services/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();

    }

}
