package pl.coderslab.charity.security;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@Order(2)
public class UserSecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests((authorize) -> authorize
//                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//        );
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/form").hasRole("USER")
//                        .requestMatchers("/",
//                                "/index",
//                                "/login",
//                                "/logout",
//                                "/register",
//                                "/error",
//                                "/panel",
//                                "/css/**",
//                                "/js/**",
//                                "/images/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/")
//                        .failureUrl("/login?error=disabled")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")
//                        .invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
