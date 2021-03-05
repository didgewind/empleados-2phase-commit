package profe.empleadosdpts.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages= {"profe.empleadosdpts"}, 
	excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = EmpleadosDptsApp.class))
public class EmpleadosDptsApp {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "empleadosdpts-server");
		SpringApplication.run(EmpleadosDptsApp.class, args);
	}
	
}
