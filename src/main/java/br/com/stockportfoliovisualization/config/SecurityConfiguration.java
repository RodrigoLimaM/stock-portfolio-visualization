package br.com.stockportfoliovisualization.config;

import br.com.stockportfoliovisualization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/resources/**")
                .permitAll()
                .antMatchers("/register/**")
                .permitAll()
                .anyRequest()
                .authenticated());
        http.formLogin()
                .loginPage("/login-form")
                .defaultSuccessUrl("/portfolio")
                .loginProcessingUrl("/login")
                .permitAll();
        http.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRepository)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
