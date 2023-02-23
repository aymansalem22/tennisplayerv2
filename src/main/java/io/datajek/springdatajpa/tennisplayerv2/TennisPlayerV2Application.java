package io.datajek.springdatajpa.tennisplayerv2;

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
	private PlayerRepository repo;
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());


	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\n>> Inserting Player: {}\n",repo.insertPlayer(
				new Player("Djokovic","Serbia",Date.valueOf("1987-05-22"),81)));
		
		logger.info("\n\n>> Inserting Player: {}\n",repo.insertPlayer(
				new Player("Monfils","France",Date.valueOf("1986-09-01"),10)));
		
		logger.info("\n\n>> Update Player: {}\n",repo.updatePlayer(
				new Player(2,"Monfils","France",Date.valueOf("1986-09-01"),20)));
		
		logger.info("\n\n>> Player with id 2: {}\n", repo.getPlayerById(2));
		
		logger.info("\n\n>> Inserting Player: {}\n",repo.insertPlayer(
				new Player("Alex","Spain",Date.valueOf("1985-09-01"),50)));
		
		repo.deleteById(3);
		
	    logger.info("Inserting Player: {}", repo.insertPlayer(new Player(
                "Thiem", "Austria", Date.valueOf("1993-09-03"), 17))); 
		
		logger.info("ALL players Data: {}", repo.getAllPlayers());
		
	}

}
