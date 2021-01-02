package ynov.projetdelta.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/user/**")
						.uri("lb://userapi"))
				.route(r -> r.path("/categorie/**")
						.uri("lb://categorieapi"))
				.route(r -> r.path("/commentaire/**")
						.uri("lb://commentaireapi"))
				.route(r -> r.path("/article/**")
						.uri("lb://articleapi"))
				.build();
				
	}
	
}
