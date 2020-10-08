package com.proyecto.mycommunity;

import com.proyecto.mycommunity.auth.handler.LoginSuccessHandler;
import com.proyecto.mycommunity.models.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler successHandler;

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/home").permitAll()
                /*.antMatchers("/ver/**").hasAnyRole("USER")*/
                /*.antMatchers("/uploads/**").hasAnyRole("USER")*/
                /*.antMatchers("/form/**").hasAnyRole("ADMIN")*/
                /*.antMatchers("/eliminar/**").hasAnyRole("ADMIN")*/
                /*.antMatchers("/factura/**").has..0AnyRole("ADMIN")*/
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(successHandler)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");

    }


    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

        build.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);

        /*
                .usersByUsernameQuery("select rut, password, estado from usuarios where rut=?")
                .authoritiesByUsernameQuery("select u.rut, r.rol from roles r inner join usuarios u on (r.idUsuario=u.id ) where u.rut=?"); */


    }
}
