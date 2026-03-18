package com.isetn.laribi.laribi_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/webjars/**").permitAll()
                .requestMatchers("/showCreate", "/saveEtudiant").hasAnyAuthority("ADMIN", "AGENT")
                .requestMatchers("/modifierEtudiant", "/supprimerEtudiant").hasAnyAuthority("ADMIN")
                .requestMatchers("/ListeEtudiants", "/").hasAnyAuthority("ADMIN", "AGENT", "USER")
                .anyRequest().authenticated())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/"))
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"))
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"));
        return http.build();
    }
}
