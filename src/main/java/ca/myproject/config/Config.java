package ca.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ca.myproject.helper.CarService;
import ca.myproject.helper.CarServiceImpl;


@Configuration
public class Config {
	
	
@Bean
public CarService getCarservice(){
	
	return new CarServiceImpl();
}
	
	
	

}
