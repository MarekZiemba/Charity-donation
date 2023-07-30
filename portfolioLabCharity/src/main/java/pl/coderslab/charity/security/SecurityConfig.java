package pl.coderslab.charity.security;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
        );
        http
                .authorizeHttpRequests((requests) -> requests
                                .requestMatchers(
                                        "/admin/**",
                                        "/admin/**")
                                .hasRole("ADMIN")
                                .requestMatchers(
                                        "/form",
                                        "/user/**")
                                .hasAnyRole("USER", "ADMIN")
                                .requestMatchers(
                                        "/",
                                        "/index",
                                        "/login",
                                        "/logout",
                                        "/register",
                                        "/error",
                                        "/css/**",
                                        "/js/**",
                                        "/images/**",
                                        "/send/mail",
                                        "activate",
                                        "/accountActivated",
                                        "activationFailed")
                                .permitAll()
                                .requestMatchers(HttpMethod.POST).permitAll().requestMatchers("/send/mail").permitAll()
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=disabled")
                .permitAll()
                )
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")
                        .invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
//                .csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
