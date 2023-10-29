package com.imranmadbar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
    

    @Bean
    @SuppressWarnings("unchecked")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
                .authorizeHttpRequests(registry -> registry
                        .antMatchers("/").permitAll()
                        .antMatchers("/home/**").permitAll()
                        .antMatchers("/admin/**").hasRole("editor")
                        .antMatchers("/manager/**").hasRole("viewer")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2Configurer -> oauth2Configurer
                		.jwt(jwtConfigurer -> jwtConfigurer
                	    .jwtAuthenticationConverter(jwt -> {
			                	Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
			                    System.out.println("realmAccess: "+realmAccess.toString());
			                    Collection<String> roles = realmAccess.get("roles");
			                    System.out.println("realmAccessRoles: "+roles.toString());
			                    List<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
			                    	    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
			                    	    .collect(Collectors.toList());
			                    System.out.println("grantedAuthorities: "+grantedAuthorities.toString());
			                    
			                    
			                    Collection<GrantedAuthority> authorities =
			                            (Collection)
			                                Stream.concat(
			                                        (new JwtGrantedAuthoritiesConverter())
			                                        .convert(jwt)
			                                        .stream(),
			                                        extractResourceRoles(jwt, "spring-security-keycloak-resource-server").stream())
			                                    .collect(Collectors.toSet());
			                    System.out.println("authorities: "+authorities.toString());
			             
			                    return new JwtAuthenticationToken(jwt, authorities);
			                })
                	    ));

        return http.build();
    }
    
    @SuppressWarnings("unchecked")
    private static Collection<? extends GrantedAuthority> extractResourceRoles(
    	      Jwt jwt, String resourceId) {
    	    Map<String, Object> resourceAccess = (Map) jwt.getClaim("resource_access");
    	    Map resource;
    	    Collection resourceRoles;
    	    return (Collection)
    	        (resourceAccess != null
    	                && (resource = (Map) resourceAccess.get(resourceId)) != null
    	                && (resourceRoles = (Collection) resource.get("roles")) != null
    	            ? (Collection)
    	                resourceRoles.stream()
    	                    .map(
    	                        (x) -> {
    	                          return new SimpleGrantedAuthority("ROLE_" + x);
    	                        })
    	                    .collect(Collectors.toSet())
    	            : Collections.emptySet());
    	  }

}