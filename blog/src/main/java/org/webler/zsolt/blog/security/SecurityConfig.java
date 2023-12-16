package org.webler.zsolt.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return rawPassword.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return rawPassword.toString().equals(encodedPassword);
//            }
//        };
//    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());

        return auth;
    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, True FROM _user WHERE username = ?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role FROM _user LEFT JOIN role ON _user.id = role.user_id WHERE _user.username = ?");
//        return jdbcUserDetailsManager;
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}1234")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}admin")
//                .roles("USER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,admin);
//
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "/posts").hasAuthority("USER")
                        .requestMatchers(HttpMethod.GET, "/posts").hasAuthority("USER")
                        .requestMatchers(HttpMethod.DELETE, "/posts").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/posts/*/comments").hasAuthority("USER")
                        .requestMatchers(HttpMethod.GET, "/posts/*/comments").hasAuthority("USER")
                        .requestMatchers(HttpMethod.PATCH, "/posts/*/comments/**").hasAuthority("USER")
                        .requestMatchers(HttpMethod.PATCH, "/posts/*").hasAuthority("USER")
                        .requestMatchers(HttpMethod.DELETE, "/posts/*").hasAuthority("USER")
                        .requestMatchers(HttpMethod.DELETE, "/users/*").hasAuthority("USER")
                        .requestMatchers(HttpMethod.POST, "/sign-up").permitAll()
                        .anyRequest().hasAuthority("ADMIN")
        );

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }


}
