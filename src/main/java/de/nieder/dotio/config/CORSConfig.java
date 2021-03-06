package de.nieder.kick.config;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CORSConfig {


    public CORSConfig() {
        System.out.println("CoRS");
    }

    /** The SLF4J Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CORSConfig.class);

    /**
     * The pattern used to split list entries.
     */
    private static final Pattern SPLIT_PATTERN = Pattern.compile("[, \t]+");

    private String allowedOrigins = "localhost:3000";

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        System.out.println("lol");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();

        if (Strings.isNullOrEmpty(this.allowedOrigins)) {
            LOGGER.info("Disabling CORS due to no origins are defined via cors.allowed-origins property.");
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }
        LOGGER.info("Enabling CORS for origins: {}.", this.allowedOrigins);

        configuration.setAllowedOrigins(
                Collections.unmodifiableList(Arrays.asList(SPLIT_PATTERN.split(this.allowedOrigins))));
        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));

        configuration.setAllowCredentials(true);

        configuration.setAllowedHeaders(
                ImmutableList.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CACHE_CONTROL, HttpHeaders.CONTENT_TYPE));
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}