package eBIS.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	@Bean(name="Corsconfigurer")
	public WebMvcConfigurer Corsconfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/API/**").allowedMethods("POST","GET").allowedOrigins(
						"*").allowedHeaders("*");
			}
		};
	}
}
