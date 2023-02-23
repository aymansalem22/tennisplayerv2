package io.datajek.springdatajpa.tennisplayerv2.lesson2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSpringDataRepository extends JpaRepository<Player2, Integer> {

	// same ==> select p from Player p where p.nationality = ?1
	public List<Player2> findByNationality(String nationality);
}
