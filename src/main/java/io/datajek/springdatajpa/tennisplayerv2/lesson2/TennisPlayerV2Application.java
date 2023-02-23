package io.datajek.springdatajpa.tennisplayerv2.lesson2;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerV2Application implements CommandLineRunner {

	@Autowired
	private PlayerSpringDataRepository repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inserting Player: {}",
				repo.save(new Player2("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		logger.info("Inserting Player: {}",
				repo.save(new Player2("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

		logger.info("Inserting Player: {}",
				repo.save(new Player2("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));

		logger.info("Updating Player with Id 3: {}",
				repo.save(new Player2(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
		logger.info("Player with Id 2: {}", repo.findById(2));
		logger.info("All Player Data: {}", repo.findAll());

		repo.deleteById(2);

		logger.info("Nationality Data: {}", repo.findByNationality("Austria"));
	}

}
