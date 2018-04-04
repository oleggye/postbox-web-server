package by.bsac.tcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ApplicationUserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*http
        .authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/templates/**", "/static/**", "/css/**", "/js/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll();*/

    http.authorizeRequests()
        .antMatchers("/app/secure/**").hasAnyRole("ADMIN", "USER")
        .and().formLogin()  //login configuration
        .loginPage("/app/login")
        .loginProcessingUrl("/app-login")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/app/secure/home")
        .and().logout()    //logout configuration
        .logoutUrl("/app-logout")
        .logoutSuccessUrl("/app/login")
        .and().exceptionHandling() //exception handling configuration
        .accessDeniedPage("/app/error");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

}
