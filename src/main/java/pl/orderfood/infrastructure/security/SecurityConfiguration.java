package pl.orderfood.infrastructure.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService
    ) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity http,
            AuthenticationProvider authenticationProvider
    )
            throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }

    @Bean
    @ConditionalOnProperty(value = "spring.security.enabled", havingValue = "true", matchIfMissing = true)
    SecurityFilterChain securityEnabled(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/login", "/", "/register", "/error"
                                    , "/images/oh_no.png", "/sign_in","/payment/**").permitAll()
                            .requestMatchers("/restaurant", "/existing_restaurant", "/add_restaurant"
                                    , "/add_meal", "/add_delivery_street", "/restaurant_orders"
                                    , "/complete_order").hasAuthority("RESTAURANT")
                            .requestMatchers("/customer", "/street", "/find_restaurant",
                                    "/select_restaurant", "/create_order")
                            .hasAuthority("CUSTOMER")
                            .anyRequest().authenticated();
                })
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Ścieżka wylogowania
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .csrf(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    @ConditionalOnProperty(value = "spring.security.enabled", havingValue = "false")
    SecurityFilterChain securityDisabled(HttpSecurity http) throws Exception {
        return http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .anyRequest()
                        .permitAll())
                .build();
    }


}
