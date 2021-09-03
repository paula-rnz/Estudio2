package com.bolsadeideas.springboot.di.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/factura/**").hasAnyRole("USER").anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
		
	}
	

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		//UserBuilder users = User.withDefaultPasswordEncoder();
		//forma antigua de hacerlo, actualmente obsoleto
		
		PasswordEncoder encoder = passwordEncoder();
		
	/*	UserBuilder users = User.builder().passwordEncoder(password -> {
			return encoder.encode(password);
		});*/
		
		//lambda mas simple
		//UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		
		//la forma mas simple de hacer la funcion lambda
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication().withUser(users.username("admin").password("12345").roles("ADMIN", "USER"));
		builder.inMemoryAuthentication().withUser(users.username("belcy").password("12345").roles("USER"));
		
	}
	
}
