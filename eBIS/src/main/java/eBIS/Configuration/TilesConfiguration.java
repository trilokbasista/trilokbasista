package eBIS.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {
	 @Bean
		public UrlBasedViewResolver tilesViewResolver() {
			UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
			tilesViewResolver.setViewClass(TilesView.class);
			//System.out.println("UrlBasedViewResolver");
			return tilesViewResolver;
		}

		@Bean
		public TilesConfigurer tilesConfigurer() {
			TilesConfigurer tilesConfigurer = new TilesConfigurer();
			tilesConfigurer.setDefinitions("classpath:/templates/tiles.xml");
			tilesConfigurer.setCheckRefresh(true);
			//System.out.println("TilesConfigurer");
			return tilesConfigurer;
		}
		
}
