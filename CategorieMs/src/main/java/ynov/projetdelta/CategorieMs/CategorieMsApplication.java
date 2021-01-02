package ynov.projetdelta.CategorieMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ynov.projetdelta.CategorieMs.CategorieMsApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class CategorieMsApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CategorieMsApplication.class, args);
	}

}
