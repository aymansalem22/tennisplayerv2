package io.datajek.springdatajpa.tennisplayerv2;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PlayerRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Player insertPlayer(Player player) {
		return entityManager.merge(player);
	}

	public Player updatePlayer(Player player) {
		return entityManager.merge(player);
	}

	public Player getPlayerById(int id) {
		return entityManager.find(Player.class, id);
	}
	
	public void deleteById(int id) {
		Player player=entityManager.find(Player.class,id);
		entityManager.remove(player);
	}

}
