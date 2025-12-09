package com.example.demo.Config;

import com.cloudinary.Cloudinary;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByUsernameIgnoreCase(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username " + username));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Value("${cloud.name}")
    private String cloudName;

    @Value("${api.key}")
    private String CloudApiKey;

    @Value("${api.secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary(){
        Map<String, Object> cloudConfig = new HashMap<>();
        cloudConfig.put("cloud_name", cloudName);
        cloudConfig.put("api_key", CloudApiKey);
        cloudConfig.put("api_secret", apiSecret);
        cloudConfig.put("secure", true);
        return new Cloudinary(cloudConfig);
    }



    @Value("${openai.api.key}")
    private String apiKey;

//    @Bean("openAiRestTemplate")
//    public RestTemplate openAiRestTemplate(RestTemplateBuilder builder) {
//        if (apiKey == null || apiKey.isEmpty()) {
//            throw new IllegalStateException("API key is missing or empty!");
//        }
//
//        return builder
//                .defaultHeader("Accept", "application/json")
//                .defaultHeader("Authorization", "Bearer " + apiKey)
//                .defaultHeader("HTTP-Referer", "http://localhost:8080")
//                .defaultHeader("Content-Type", "application/json")
//                .build();
//    }

}
