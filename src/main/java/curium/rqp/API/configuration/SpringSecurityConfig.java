package curium.rqp.API.configuration;

import curium.rqp.API.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.formLogin(login -> login.defaultSuccessUrl("http://localhost:4200/Accueil", true))
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
				.csrf(csrf -> csrf.disable());


		return http.build();
	}


	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
		return username -> userRepository.findByUsername(username)
				.map(user -> org.springframework.security.core.userdetails.User.builder()
						.username(user.getUsername())
						.password(user.getPassword())
						.roles(user.getRoles().stream()
								.map(role -> role.getName().replace("ROLE_", ""))
								.toArray(String[]::new))
						.build())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
