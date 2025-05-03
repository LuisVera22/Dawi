package com.ciberfarma.dawi_tema05.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() // Deshabilita CSRF para la API de prueba
				.authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.GET, "/api/productos/**").permitAll() // GET es público
				.requestMatchers(HttpMethod.POST, "/api/productos").permitAll() //.hasRole("ADMIN") // POST solo ADMIN
				.requestMatchers(HttpMethod.DELETE, "/api/productos").permitAll() //.hasRole("ADMIN") // POST solo ADMIN
				.requestMatchers(HttpMethod.PUT, "/api/productos").permitAll() //.hasRole("ADMIN") // POST solo ADMIN
				.requestMatchers(HttpMethod.POST, "/api/usuarios/registrar").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/categorias/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/proveedores/**").permitAll()
				//.requestMatchers(HttpMethod.DELETE, "/api/productos").hasRole("ADMIN")
				 //.requestMatchers("/api/productos/**").hasRole("ADMIN") // Solo ADMIN																							
				.anyRequest().authenticated())
				.httpBasic(); // método de autenticación .formLogin()
		return http.build();
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Usuario en memoria de ejemplo
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder() // .withDefaultPasswordEncoder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
