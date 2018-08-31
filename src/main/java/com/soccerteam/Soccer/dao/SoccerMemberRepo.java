package com.soccerteam.Soccer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soccerteam.Soccer.entity.Members;

@Repository
public interface SoccerMemberRepo extends JpaRepository<Members, Long> {

	List<Members> findAll();
	
	@Query("select membername from Members")
	List<String> getMemberNames();
}
