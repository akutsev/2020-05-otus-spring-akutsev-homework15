package ru.otus.akutsev.excursions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.akutsev.excursions.service.ExcursionService;
import ru.otus.akutsev.excursions.service.ExcursionServiceImpl;

@SpringBootApplication
public class ExcursionsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ExcursionsApplication.class, args);

		var ctx = SpringApplication.run(ExcursionsApplication.class, args);
		ExcursionService service = ctx.getBean(ExcursionServiceImpl.class);
		service.getExcursion().getAttractions().forEach(System.out::println);
	}

}
