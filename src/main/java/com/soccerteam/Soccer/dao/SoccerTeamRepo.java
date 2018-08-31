package com.soccerteam.Soccer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccerteam.Soccer.entity.Members;
import com.soccerteam.Soccer.entity.Teams;

@Repository
public interface SoccerTeamRepo extends JpaRepository<Teams, Long>{

	List<Teams> findAll();
	
	@Query ("select teamname from Teams")
	List<String> getTeamNames();
	
	@Query ("select Members from Teams")
	List<Members> getMembersInTeam(Long id);
}
