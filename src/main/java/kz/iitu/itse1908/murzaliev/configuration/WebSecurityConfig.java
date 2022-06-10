package kz.iitu.itse1908.murzaliev.configuration;

import kz.iitu.itse1908.murzaliev.security.CustomOAuth2User;
import kz.iitu.itse1908.murzaliev.security.CustomOAuth2UserService;
import kz.iitu.itse1908.murzaliev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;
    private CustomOAuth2UserService oauthUserService;

    @Autowired
    public WebSecurityConfig(UserService userService, CustomOAuth2UserService oauthUserService) {
        this.userService = userService;
        this.oauthUserService = oauthUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/login", "/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                    .loginPage("/auth")
                .and()
                .oauth2Login()
                    .loginPage("/auth")
                    .userInfoEndpoint()
                        .userService(oauthUserService)
                    .and()
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

                            userService.processOAuthPostLogin(oauthUser.getEmail());
                            httpServletResponse.sendRedirect("/");
                        }
                    });
    }
}
