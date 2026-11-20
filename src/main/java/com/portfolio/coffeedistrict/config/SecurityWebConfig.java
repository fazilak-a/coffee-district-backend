
    package com.portfolio.coffeedistrict.config;

    import jakarta.servlet.DispatcherType;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


    import java.util.List;


    @Configuration
    public class SecurityWebConfig {

        @Autowired
        UserAuthenticationProvider userAuthenticationProvider;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {


            httpSecurity.cors(Customizer.withDefaults());


            // CSRF is disabled to simplify local API testing with Postman
            // This project uses session-based authentication
            // CSRF protection should be enabled and properly configured
            // before deploying the application to production

            httpSecurity.csrf(csrfConfig -> csrfConfig.disable());



            httpSecurity.formLogin(loginConfig -> {
                loginConfig.loginProcessingUrl("/auth/login");
                loginConfig.usernameParameter("email");
                loginConfig.passwordParameter("password");

                loginConfig.successHandler((request, response, authentication) -> {
                    response.setStatus(200);
                });

                loginConfig.failureHandler((request, response, exception) -> {
                    response.setStatus(401);
                });
            });


            httpSecurity.exceptionHandling(ex ->
                    ex.authenticationEntryPoint((request, response, authException) -> {
                        response.setStatus(401);
                        response.getWriter().write("Unauthorized");
                    })
            );



            httpSecurity.authorizeHttpRequests(auth -> {
                auth.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll();


                auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();


                // =========================
                // PUBLIC AUTH ENDPOINTS
                // =========================

                auth.requestMatchers(
                        "/",
                        "/auth/register",
                        "/auth/login"

                ).permitAll();



                // =========================
                // PUBLIC READ ENDPOINTS
                // =========================

                auth.requestMatchers(HttpMethod.GET, "/products/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/coffees/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/cookies/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/machines/**").permitAll();



                // =========================
                // PROTECTED AUTHENTICATED USER ENDPOINTS
                // =========================

                auth.requestMatchers("/auth/me").hasRole("USER");


                auth.anyRequest().denyAll();
            });


            httpSecurity.authenticationProvider(userAuthenticationProvider);

            return httpSecurity.build();
        }


        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();

            configuration.setAllowedOrigins(List.of(
                    "http://localhost:5173",
                    "http://localhost:5174",
                    "http://localhost:5175"
            ));

            configuration.setAllowedMethods(List.of(
                    "GET",
                    "POST",
                    "PATCH",
                    "PUT",
                    "DELETE",
                    "OPTIONS"
            ));

            configuration.setAllowedHeaders(List.of("*"));
            configuration.setAllowCredentials(true);

            UrlBasedCorsConfigurationSource source =
                    new UrlBasedCorsConfigurationSource();

            source.registerCorsConfiguration("/**", configuration);

            return source;
        }
    }

